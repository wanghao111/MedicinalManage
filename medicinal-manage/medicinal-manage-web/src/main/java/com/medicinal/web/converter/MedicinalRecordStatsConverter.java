package com.medicinal.web.converter;

import com.medicinal.dao.params.MedicinalStatisticsPageQuery;
import com.medicinal.web.dto.MedicinalReserveStasPageParam;

public class MedicinalRecordStatsConverter {

    public static MedicinalStatisticsPageQuery reserveStasPageParam2statisticsPageQuery(MedicinalReserveStasPageParam param) {
        MedicinalStatisticsPageQuery query = MedicinalStatisticsPageQuery.builder()
                .month(param.getMonth())
                .build();
        query.setPage(param.getPage());
        query.setPageSize(param.getPageSize());
        return query;
    }
}
