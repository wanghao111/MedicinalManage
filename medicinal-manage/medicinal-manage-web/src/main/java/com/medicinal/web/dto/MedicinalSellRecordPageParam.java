package com.medicinal.web.dto;

import lombok.Data;

@Data
public class MedicinalBuyRecordPageParam extends PageRequestBase{

    private String medicinalCode;

    private String medicinalName;

    private String buyerName;

    private Integer buyerNumber;
}
