package com.medicinal.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicinalBuyRecordVO {

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
