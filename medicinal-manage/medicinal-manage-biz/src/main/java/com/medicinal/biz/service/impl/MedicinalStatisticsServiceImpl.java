package com.medicinal.biz.service.impl;

import com.medicinal.biz.converter.MedicinalReserveRecordConverter;
import com.medicinal.biz.converter.MedicinalReserveStaConverter;
import com.medicinal.biz.model.MedicinalReserveRecord;
import com.medicinal.biz.model.MedicinalReserveStatistics;
import com.medicinal.biz.model.MedicinalStatisticsEntry;
import com.medicinal.biz.service.MedicinalStatisticsService;
import com.medicinal.dao.mapper.MedicinalReserveRecordDao;
import com.medicinal.dao.params.MedicinalStatisticsPageQuery;
import com.medicinal.dao.vo.MedicinalReserveRecordVO;
import com.medicinal.dao.vo.MedicinalReserveStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinalStatisticsServiceImpl implements MedicinalStatisticsService {

    @Autowired
    private MedicinalReserveRecordDao medicinalReserveRecordDao;

//    @Override
//    public List<MedicinalStatisticsEntry> queryListByMonth(MedicinalStatisticsPageQuery query) {
//        return null;
//    }

    @Override
    public int getDistinctTotalCountByMonth(String month) {
        return medicinalReserveRecordDao.getDistinctTotalCountByMonth(month);
    }

    @Override
    public List<String> pageQueryDistinctMedicinal(MedicinalStatisticsPageQuery query) {
        return medicinalReserveRecordDao.pageQueryDistinctMedicinal(query);
    }

    @Override
    public List<MedicinalReserveStatistics> queryRecordStatisticsListByMonth(String month, List<String> medicinalCodes) {
        List<MedicinalReserveStatisticsVO> reserveStatisticsVOS = medicinalReserveRecordDao.queryRecordStatisticsListByMonth(month, medicinalCodes);
        return MedicinalReserveStaConverter.reserveStasListVO2ReserveStasList(reserveStatisticsVOS);
    }

    @Override
    public List<MedicinalReserveRecord> getLastRecord(String month, List<String> medicinalCodes) {
        List<MedicinalReserveRecordVO> lastRecord = medicinalReserveRecordDao.getLastRecord(month, medicinalCodes);
        return MedicinalReserveRecordConverter.reserveRecordVOS2ReserveRecords(lastRecord);
    }

}
