package com.medicinal.dao.params;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicinalStatisticsPageQuery extends PageQueryBase{

    /**
     * 2022-02
     */
    private String month;

}
