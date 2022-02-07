package com.medicinal.biz.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class MedicinalReserveRecord {

    private Long id;

    private String medicinalCode;

    private String medicinalName;

    private Integer count;

    private float unitPrice;

    private float totalPrice;

    /**
     * 1:新增库存，2:扣减库存，默认0
     */
    private Integer reserveType;

    private Integer currentReserve;

    private Float currentTotalPrice;

    private Timestamp createTime;

    private Timestamp updateTime;
}
