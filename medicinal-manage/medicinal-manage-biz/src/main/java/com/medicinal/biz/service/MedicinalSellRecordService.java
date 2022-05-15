package com.medicinal.biz.service;

import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.dao.params.MedicinalBuyRecordPageQuery;

import java.util.List;


public interface MedicinalBuyRecordService {


    int create(MedicinalBuyRecord medicinalBuyRecord);

    List<MedicinalBuyRecord> queryList(MedicinalBuyRecordPageQuery query);

    int getTotalCount(MedicinalBuyRecordPageQuery query);

}
