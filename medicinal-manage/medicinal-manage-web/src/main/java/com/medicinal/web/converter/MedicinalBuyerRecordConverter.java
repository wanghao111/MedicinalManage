package com.medicinal.web.converter;

import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.web.dto.MedicinalBuyRecordDTO;

public class MedicinalBuyerRecordConverter {

    public static MedicinalBuyRecord buyRecordDTO2BuyRecord(MedicinalBuyRecordDTO buyRecordDTO) {
        MedicinalBuyRecord record = MedicinalBuyRecord.builder()
                .medicinalCode(buyRecordDTO.getMedicinalCode())
                .medicinalName(buyRecordDTO.getMedicinalName())
                .count(buyRecordDTO.getCount())
                .unitPrice(buyRecordDTO.getUnitPrice())
                .totalPrice(buyRecordDTO.getTotalPrice())
                .buyerNumber(buyRecordDTO.getBuyerNumber())
                .buyerName(buyRecordDTO.getBuyerName())
                .build();
        return record;
    }
}
