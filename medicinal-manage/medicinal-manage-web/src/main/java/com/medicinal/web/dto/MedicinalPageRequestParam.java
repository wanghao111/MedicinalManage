package com.medicinal.web.dto;

import lombok.Data;

@Data
public class MedicinalPageRequestParam extends PageRequestBase{


    private String code;

    private String name;

}
