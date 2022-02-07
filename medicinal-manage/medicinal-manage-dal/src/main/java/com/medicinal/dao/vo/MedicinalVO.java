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
public class MedicinalVO {

    private Long id;

    private String code;

    private String name;

    private String unit;

    private float unitPrice;

    private Integer reserve;

    private Timestamp createTime;

    private Timestamp updateTime;

}
