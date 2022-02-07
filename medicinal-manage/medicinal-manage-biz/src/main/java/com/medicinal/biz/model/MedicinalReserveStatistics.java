package com.medicinal.biz.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicinalReserveStatistics {

    private String medicinalCode;

    private String medicinalName;

    private Integer reserveType;

    private Integer count;

    private Float totalPrice;
}
