package com.medicinal.web.dto;

import lombok.Data;

@Data
public class MedicinalReserveRecordPageParam extends PageRequestBase{

    private String medicinalCode;

    private String medicinalName;
}
