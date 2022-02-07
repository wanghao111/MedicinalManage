package com.medicinal.web.factory;

import com.medicinal.dao.params.MedicinalBuyRecordPageQuery;
import com.medicinal.dao.params.MedicinalPageQueryParam;
import com.medicinal.dao.params.MedicinalReserveRecordPageQuery;
import com.medicinal.web.dto.MedicinalBuyRecordPageParam;
import com.medicinal.web.dto.MedicinalPageRequestParam;
import com.medicinal.web.dto.MedicinalReserveRecordPageParam;

public class PageQueryFacotry {

    public static MedicinalPageQueryParam MedicinalPageRequestParam2Query(MedicinalPageRequestParam param) {
        MedicinalPageQueryParam pageQueryParam = MedicinalPageQueryParam.builder()
                .code(param.getCode())
                .name(param.getName())
                .build();
        pageQueryParam.setPage(param.getPage());
        pageQueryParam.setPageSize(param.getPageSize());
        return pageQueryParam;
    }

    public static MedicinalBuyRecordPageQuery buyerRecordPageRequestParam2Query(MedicinalBuyRecordPageParam param) {
        MedicinalBuyRecordPageQuery pageQueryParam = MedicinalBuyRecordPageQuery.builder()
                .medicinalCode(param.getMedicinalCode())
                .medicinalName(param.getMedicinalName())
                .buyerName(param.getBuyerName())
                .buyerNumber(param.getBuyerNumber())
                .build();
        pageQueryParam.setPage(param.getPage());
        pageQueryParam.setPageSize(param.getPageSize());
        return pageQueryParam;
    }

    public static MedicinalReserveRecordPageQuery reserveRecordPageRequestParam2Query(MedicinalReserveRecordPageParam param) {
        MedicinalReserveRecordPageQuery query = MedicinalReserveRecordPageQuery.builder()
                .medicinalCode(param.getMedicinalCode())
                .medicinalName(param.getMedicinalName())
                .build();
        query.setPage(param.getPage());
        query.setPageSize(param.getPageSize());
        return query;
    }
}
