package com.medicinal.dao.mapper;

import com.medicinal.dao.params.MedicinalBuyRecordPageQuery;
import com.medicinal.dao.vo.MedicinalBuyRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicinalBuyRecordDao {

    int create(MedicinalBuyRecordVO medicinalBuyRecord);

    List<MedicinalBuyRecordVO> queryList(@Param("param") MedicinalBuyRecordPageQuery query);

    int getTotalCount(@Param("param") MedicinalBuyRecordPageQuery query);

}
