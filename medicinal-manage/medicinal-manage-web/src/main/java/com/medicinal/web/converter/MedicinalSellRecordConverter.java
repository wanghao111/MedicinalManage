package com.medicinal.web.converter;

import com.medicinal.biz.model.MedicinalSellRecord;
import com.medicinal.web.dto.MedicinalBuyRecordDTO;

public class MedicinalBuyerRecordConverter {

    public static MedicinalSellRecord buyRecordDTO2BuyRecord(MedicinalBuyRecordDTO buyRecordDTO) {
        MedicinalSellRecord record = MedicinalSellRecord.builder()
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
