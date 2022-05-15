package com.medicinal.biz.service.impl;

import com.medicinal.biz.converter.MedicinalBuyRecordConverter;
import com.medicinal.biz.converter.MedicinalReserveRecordConverter;
import com.medicinal.biz.enums.ReserveType;
import com.medicinal.biz.model.Medicinal;
import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.biz.service.MedicinalBuyRecordService;
import com.medicinal.biz.service.MedicinalService;
import com.medicinal.dao.mapper.MedicinalSellRecordDao;
import com.medicinal.dao.params.MedicinalBuyRecordPageQuery;
import com.medicinal.dao.vo.MedicinalSellRecordVO;
import com.medicinal.dao.vo.MedicinalReserveRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicinalBuyRecordServiceImpl implements MedicinalBuyRecordService {

    @Autowired
    private MedicinalSellRecordDao medicinalSellRecordDao;

    @Autowired
    private MedicinalService medicinalService;

    @Override
    @Transactional
    public int create(MedicinalBuyRecord medicinalBuyRecord) {

        Medicinal medicinal = medicinalService.get(medicinalBuyRecord.getMedicinalCode());
        if (medicinal == null || medicinal.getReserve() < medicinalBuyRecord.getCount()) {
            return -1;
        }

        medicinalService.decrementReserve(medicinal.getCode(), medicinalBuyRecord.getCount());

        int createNUm = medicinalSellRecordDao.create(MedicinalBuyRecordConverter.buyRecord2BuyRecordVO(medicinalBuyRecord));

        MedicinalReserveRecordVO medicinalReserveRecordVO = MedicinalReserveRecordConverter.buyerRecord2ReserveRecordVO(medicinalBuyRecord);
        medicinalReserveRecordVO.setReserveType(ReserveType.DEL_RESERVE.getType());
        medicinalReserveRecordVO.setCurrentReserve(medicinal.getReserve() - medicinalBuyRecord.getCount());
        medicinalReserveRecordVO.setCurrentTotalPrice(medicinalReserveRecordVO.getCurrentReserve() * medicinal.getUnitPrice());

        medicinalService.createReserveRecord(medicinalReserveRecordVO);
        return createNUm;
    }

    @Override
    public List<MedicinalBuyRecord> queryList(MedicinalBuyRecordPageQuery query) {
        List<MedicinalSellRecordVO> medicinalSellRecordVOS = medicinalSellRecordDao.queryList(query);
        return MedicinalBuyRecordConverter.buyRecords2BuyRecordVOs(medicinalSellRecordVOS);
    }

    @Override
    public int getTotalCount(MedicinalBuyRecordPageQuery query) {
        return medicinalSellRecordDao.getTotalCount(query);
    }
}
