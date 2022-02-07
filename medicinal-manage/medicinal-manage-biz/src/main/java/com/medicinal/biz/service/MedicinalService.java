package com.medicinal.biz.service;

import com.medicinal.biz.model.Medicinal;
import com.medicinal.biz.model.MedicinalReserveRecord;
import com.medicinal.dao.params.MedicinalPageQueryParam;
import com.medicinal.dao.params.MedicinalReserveRecordPageQuery;
import com.medicinal.dao.vo.MedicinalReserveRecordVO;

import java.util.List;

public interface MedicinalService {

    public int create(Medicinal medicinal);

    public List<Medicinal> queryList(MedicinalPageQueryParam param);

    public int getTotalCount(MedicinalPageQueryParam param);


    public int update(Medicinal medicinal);

    Medicinal get(String code);

    public int delete(String code);

    int decrementReserve(String code, int delCount);

    int createReserveRecord(MedicinalReserveRecordVO medicinalReserveRecordVO);

    public List<MedicinalReserveRecord> queryReserveRecordList(MedicinalReserveRecordPageQuery param);

    public int getReserveRecordTotalCount(MedicinalReserveRecordPageQuery param);
}
