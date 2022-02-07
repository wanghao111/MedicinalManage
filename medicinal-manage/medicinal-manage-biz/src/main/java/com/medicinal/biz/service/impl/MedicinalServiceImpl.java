package com.medicinal.biz.service.impl;

import com.medicinal.biz.converter.MedicinalConverter;
import com.medicinal.biz.converter.MedicinalReserveRecordConverter;
import com.medicinal.biz.enums.ReserveType;
import com.medicinal.biz.model.Medicinal;
import com.medicinal.biz.model.MedicinalReserveRecord;
import com.medicinal.biz.service.MedicinalService;
import com.medicinal.dao.mapper.MedicinalDao;
import com.medicinal.dao.mapper.MedicinalReserveRecordDao;
import com.medicinal.dao.params.MedicinalPageQueryParam;
import com.medicinal.dao.params.MedicinalReserveRecordPageQuery;
import com.medicinal.dao.vo.MedicinalReserveRecordVO;
import com.medicinal.dao.vo.MedicinalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinalServiceImpl implements MedicinalService {
    @Autowired
    private MedicinalDao medicinalDao;

    @Autowired
    private MedicinalReserveRecordDao medicinalReserveRecordDao;

    public int create(Medicinal medicinal) {
        int insertNum = medicinalDao.create(MedicinalConverter.medicinal2MedicinalVO(medicinal));
        if (insertNum > 0) {
            MedicinalReserveRecordVO reserveRecordVO = MedicinalReserveRecordConverter.medicinal2ReserveRecordVO(medicinal);
            reserveRecordVO.setReserveType(ReserveType.ADD_RESERVE.getType());
            reserveRecordVO.setCurrentReserve(medicinal.getReserve());
            reserveRecordVO.setCurrentTotalPrice(medicinal.getReserve() * medicinal.getUnitPrice());
            medicinalReserveRecordDao.create(reserveRecordVO);
        }
        return insertNum;
    }


    public List<Medicinal> queryList(MedicinalPageQueryParam param) {
        List<MedicinalVO> medicinalVOS = medicinalDao.queryList(param);
        return MedicinalConverter.medicinals2MedicinalVOs(medicinalVOS);
    }

    public int getTotalCount(MedicinalPageQueryParam param) {
        int totalCount = medicinalDao.getTotalCount(param);
        return totalCount;
    }


    public int update(Medicinal medicinal) {
        MedicinalVO oldMedicinal = medicinalDao.get(medicinal.getCode());
        if (null == oldMedicinal) {
            return 0;
        }
        int updateNum = medicinalDao.update(MedicinalConverter.medicinal2MedicinalVO(medicinal));

        if (updateNum > 0) {
            MedicinalReserveRecordVO reserveRecordVO = MedicinalReserveRecordConverter.medicinal2ReserveRecordVO(medicinal);
            if (oldMedicinal.getReserve() > medicinal.getReserve()) {
                reserveRecordVO.setReserveType(ReserveType.DEL_RESERVE.getType());
                reserveRecordVO.setCount(oldMedicinal.getReserve() - medicinal.getReserve());
                reserveRecordVO.setTotalPrice(reserveRecordVO.getCount() * reserveRecordVO.getUnitPrice());

                reserveRecordVO.setCurrentReserve(medicinal.getReserve());
                reserveRecordVO.setCurrentTotalPrice(medicinal.getReserve() * medicinal.getUnitPrice());
            } else if (oldMedicinal.getReserve() < medicinal.getReserve()) {
                reserveRecordVO.setReserveType(ReserveType.ADD_RESERVE.getType());
                reserveRecordVO.setCount(medicinal.getReserve() - oldMedicinal.getReserve());
                reserveRecordVO.setTotalPrice(reserveRecordVO.getCount() * reserveRecordVO.getUnitPrice());

                reserveRecordVO.setCurrentReserve(medicinal.getReserve());
                reserveRecordVO.setCurrentTotalPrice(medicinal.getReserve() * medicinal.getUnitPrice());
            }
            medicinalReserveRecordDao.create(reserveRecordVO);
        }
        return updateNum;
    }

    @Override
    public Medicinal get(String code) {
        MedicinalVO medicinalVO = medicinalDao.get(code);
        return MedicinalConverter.medicinalVO2Medicinal(medicinalVO);
    }

    public int delete(String code) {
        return medicinalDao.delete(code);
    }

    @Override
    public int decrementReserve(String code, int delCount) {
        return medicinalDao.decrementReserve(code, delCount);
    }

    @Override
    public int createReserveRecord(MedicinalReserveRecordVO medicinalReserveRecordVO) {
        return medicinalReserveRecordDao.create(medicinalReserveRecordVO);
    }

    @Override
    public List<MedicinalReserveRecord> queryReserveRecordList(MedicinalReserveRecordPageQuery param) {
        List<MedicinalReserveRecordVO> medicinalReserveRecordVOS = medicinalReserveRecordDao.queryList(param);
        return MedicinalReserveRecordConverter.reserveRecordVOS2ReserveRecords(medicinalReserveRecordVOS);
    }

    @Override
    public int getReserveRecordTotalCount(MedicinalReserveRecordPageQuery param) {
        int totalCount = medicinalReserveRecordDao.getTotalCount(param);
        return totalCount;
    }


}
