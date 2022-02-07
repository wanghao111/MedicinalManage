package com.medicinal.biz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicinalStatisticsEntry {

    private Long id;

    private String medicinalCode;

    private String medicinalName;

    private float unitPrice;

    private int preMonthSurplusCount;

    private float preMonthSurplusTotalPrice;

    private int currentMonthAddCount;

    private float currentMonthAddTotalPrice;

    private int currentMonthSaleCount;

    private float currentMonthSaleTotalPrice;

    private int currentReserve;

    private float currentTotalPrice;

    private Timestamp createTime;

    private Timestamp updateTime;

}
