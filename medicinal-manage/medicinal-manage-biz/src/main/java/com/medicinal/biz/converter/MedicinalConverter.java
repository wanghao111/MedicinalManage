package com.medicinal.biz.converter;

import com.medicinal.biz.model.Medicinal;
import com.medicinal.dao.vo.MedicinalVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicinalConverter {

    public static MedicinalVO medicinal2MedicinalVO(Medicinal medicinal) {
        if (null != medicinal) {
            MedicinalVO medicinalVO = MedicinalVO.builder()
                    .id(medicinal.getId())
                    .code(medicinal.getCode())
                    .name(medicinal.getName())
                    .unit(medicinal.getUnit())
                    .unitPrice(medicinal.getUnitPrice())
                    .reserve(medicinal.getReserve())
                    .build();
            return medicinalVO;
        }
        return MedicinalVO.builder().build();
    }

    public static Medicinal medicinalVO2Medicinal(MedicinalVO medicinalVO) {
        if (null != medicinalVO) {
            Medicinal medicinal = Medicinal.builder()
                    .id(medicinalVO.getId())
                    .code(medicinalVO.getCode())
                    .name(medicinalVO.getName())
                    .unit(medicinalVO.getUnit())
                    .unitPrice(medicinalVO.getUnitPrice())
                    .reserve(medicinalVO.getReserve())
                    .build();
            return medicinal;
        }
        return Medicinal.builder().build();
    }

    public static List<Medicinal> medicinals2MedicinalVOs(List<MedicinalVO> medicinalVOS) {
        List<Medicinal> result = new ArrayList<>();

        Optional.of(medicinalVOS).ifPresent(list->{
            list.forEach(medicinal -> {result.add(medicinalVO2Medicinal(medicinal));});
        });
        return result;
    }

}
