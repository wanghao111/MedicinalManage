package com.medicinal.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicinalReserveStatisticsVO {

    private String medicinalCode;

    private String medicinalName;

    private Integer reserveType;

    private Integer count;

    private Float totalPrice;

}
