package com.medicinal.web.dto;

import lombok.Data;

@Data
public class MedicinalDTO {

    private Long id;

    private String code;

    private String name;

    private String unit;

    private float unitPrice;

    private Integer reserve;

}
