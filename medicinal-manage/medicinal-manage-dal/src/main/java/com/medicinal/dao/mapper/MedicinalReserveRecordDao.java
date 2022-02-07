package com.medicinal.dao.mapper;

import com.medicinal.dao.params.MedicinalReserveRecordPageQuery;
import com.medicinal.dao.params.MedicinalStatisticsPageQuery;
import com.medicinal.dao.vo.MedicinalReserveRecordVO;
import com.medicinal.dao.vo.MedicinalReserveStatisticsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicinalReserveRecordDao {
    int create(MedicinalReserveRecordVO medicinalReserveRecordVO);

    List<MedicinalReserveRecordVO> queryList(@Param("param") MedicinalReserveRecordPageQuery query);

    int getTotalCount(@Param("param") MedicinalReserveRecordPageQuery query);

    int getDistinctTotalCountByMonth(@Param("month") String month);

    List<String> pageQueryDistinctMedicinal(@Param("param") MedicinalStatisticsPageQuery query);

    List<MedicinalReserveStatisticsVO> queryRecordStatisticsListByMonth(@Param("month") String month,@Param("medicinalCodes") List<String> medicinalCodes);

    List<MedicinalReserveRecordVO> getLastRecord(@Param("month") String month,@Param("medicinalCodes") List<String> medicinalCodes);
}
