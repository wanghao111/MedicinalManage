package com.medicinal.biz.service;

import com.medicinal.biz.model.MedicinalReserveRecord;
import com.medicinal.biz.model.MedicinalReserveStatistics;
import com.medicinal.dao.params.MedicinalStatisticsPageQuery;

import java.util.List;

public interface MedicinalStatisticsService {

//    List<MedicinalStatisticsEntry> queryListByMonth(MedicinalStatisticsPageQuery query);

    int getDistinctTotalCountByMonth(String month);

    List<String> pageQueryDistinctMedicinal( MedicinalStatisticsPageQuery query);

    List<MedicinalReserveStatistics> queryRecordStatisticsListByMonth(String month, List<String> medicinalCodes);

    List<MedicinalReserveRecord> getLastRecord(String month, List<String> medicinalCodes);
}
