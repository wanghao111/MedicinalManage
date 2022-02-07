package com.medicinal.biz.converter;

import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.dao.vo.MedicinalBuyRecordVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicinalBuyRecordConverter {

    public static MedicinalBuyRecordVO buyRecord2BuyRecordVO(MedicinalBuyRecord record) {
        MedicinalBuyRecordVO medicinalBuyRecordVO = MedicinalBuyRecordVO.builder()
                .id(record.getId())
                .medicinalCode(record.getMedicinalCode())
                .medicinalName(record.getMedicinalName())
                .unitPrice(record.getUnitPrice())
                .count(record.getCount())
                .totalPrice(record.getCount() * record.getUnitPrice())
                .buyerName(record.getBuyerName())
                .buyerNumber(record.getBuyerNumber())
                .build();
        return medicinalBuyRecordVO;
    }

    public static MedicinalBuyRecord buyRecordVO2BuyRecord(MedicinalBuyRecordVO record) {
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

    public static List<MedicinalBuyRecord> buyRecords2BuyRecordVOs(List<MedicinalBuyRecordVO> record) {
        List<MedicinalBuyRecord> recordList = new ArrayList<>();
        Optional.of(record).ifPresent(records->records.forEach(r->{
            recordList.add(buyRecordVO2BuyRecord(r));
        }));
        return recordList;
    }
}
