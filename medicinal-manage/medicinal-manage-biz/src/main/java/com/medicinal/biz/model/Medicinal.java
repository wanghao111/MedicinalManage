package com.medicinal.biz.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Medicinal {

    private Long id;

    private String code;

    private String name;

    private String unit;

    private float unitPrice;

    private Integer reserve;
}
