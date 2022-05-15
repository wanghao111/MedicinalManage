package com.medicinal.web.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MedicinalBuyRecordDTO {

    private Long id;

    private String medicinalCode;

    private String medicinalName;

    private Integer count;

    private float unitPrice;

    private float totalPrice;

    private String buyerName;

    private Integer buyerNumber;

    private Timestamp createTime;

    private Timestamp updateTime;
}
