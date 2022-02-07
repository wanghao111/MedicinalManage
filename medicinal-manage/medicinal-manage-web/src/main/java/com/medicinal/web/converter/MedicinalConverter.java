package com.medicinal.web.converter;

import com.medicinal.biz.model.Medicinal;
import com.medicinal.web.dto.MedicinalDTO;

public class MedicinalConverter {

    public static Medicinal medicinalDTO2Medicinal(MedicinalDTO medicinalDTO) {
        if (null != medicinalDTO) {
            Medicinal medicinal = Medicinal.builder()
                    .id(medicinalDTO.getId())
                    .code(medicinalDTO.getCode())
                    .name(medicinalDTO.getName())
                    .unit(medicinalDTO.getUnit())
                    .unitPrice(medicinalDTO.getUnitPrice())
                    .reserve(medicinalDTO.getReserve())
                    .build();
            return medicinal;
        }
        return Medicinal.builder().build();
    }

}
