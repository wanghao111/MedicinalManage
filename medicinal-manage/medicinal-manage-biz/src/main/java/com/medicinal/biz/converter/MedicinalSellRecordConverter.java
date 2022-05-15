package com.medicinal.biz.converter;

import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.dao.vo.MedicinalSellRecordVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicinalBuyRecordConverter {

    public static MedicinalSellRecordVO buyRecord2BuyRecordVO(MedicinalBuyRecord record) {
        MedicinalSellRecordVO medicinalSellRecordVO = MedicinalSellRecordVO.builder()
                .id(record.getId())
                .medicinalCode(record.getMedicinalCode())
                .medicinalName(record.getMedicinalName())
                .unitPrice(record.getUnitPrice())
                .count(record.getCount())
                .totalPrice(record.getCount() * record.getUnitPrice())
                .buyerName(record.getBuyerName())
                .buyerNumber(record.getBuyerNumber())
                .build();
        return medicinalSellRecordVO;
    }

    public static MedicinalBuyRecord buyRecordVO2BuyRecord(MedicinalSellRecordVO record) {
        MedicinalBuyRecord medicinalBuyRecord = MedicinalBuyRecord.builder()
                .id(record.getId())
                .medicinalCode(record.getMedicinalCode())
                .medicinalName(record.getMedicinalName())
                .unitPrice(record.getUnitPrice())
                .count(record.getCount())
                .totalPrice(record.getCount() * record.getUnitPrice())
                .buyerName(record.getBuyerName())
                .buyerNumber(record.getBuyerNumber())
                .createTime(record.getCreateTime())
                .updateTime(record.getUpdateTime())
                .build();
        return medicinalBuyRecord;
    }

    public static List<MedicinalBuyRecord> buyRecords2BuyRecordVOs(List<MedicinalSellRecordVO> record) {
        List<MedicinalBuyRecord> recordList = new ArrayList<>();
        Optional.of(record).ifPresent(records->records.forEach(r->{
            recordList.add(buyRecordVO2BuyRecord(r));
        }));
        return recordList;
    }
}
