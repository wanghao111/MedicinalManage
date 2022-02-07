package com.medicinal.biz.converter;

import com.medicinal.biz.model.Medicinal;
import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.biz.model.MedicinalReserveRecord;
import com.medicinal.dao.vo.MedicinalBuyRecordVO;
import com.medicinal.dao.vo.MedicinalReserveRecordVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicinalReserveRecordConverter {


    public static MedicinalReserveRecordVO medicinal2ReserveRecordVO(Medicinal medicinal) {
        MedicinalReserveRecordVO medicinalReserveRecordVO = MedicinalReserveRecordVO.builder()
                .medicinalCode(medicinal.getCode())
                .medicinalName(medicinal.getName())
                .count(medicinal.getReserve())
                .unitPrice(medicinal.getUnitPrice())
                .totalPrice(medicinal.getReserve() * medicinal.getUnitPrice())
                .build();
        return medicinalReserveRecordVO;
    }

    public static MedicinalReserveRecordVO buyerRecord2ReserveRecordVO(MedicinalBuyRecord medicinalBuyRecord) {
        MedicinalReserveRecordVO medicinalReserveRecordVO = MedicinalReserveRecordVO.builder()
                .medicinalCode(medicinalBuyRecord.getMedicinalCode())
                .medicinalName(medicinalBuyRecord.getMedicinalName())
                .count(medicinalBuyRecord.getCount())
                .unitPrice(medicinalBuyRecord.getUnitPrice())
                .totalPrice(medicinalBuyRecord.getCount() * medicinalBuyRecord.getUnitPrice())
                .build();
        return medicinalReserveRecordVO;
    }

    public static MedicinalReserveRecord reserveRecordVO2ReserveRecord(MedicinalReserveRecordVO reserveRecordVO) {
        MedicinalReserveRecord reserveRecord = MedicinalReserveRecord.builder()
                .medicinalCode(reserveRecordVO.getMedicinalCode())
                .medicinalName(reserveRecordVO.getMedicinalName())
                .count(reserveRecordVO.getCount())
                .reserveType(reserveRecordVO.getReserveType())
                .id(reserveRecordVO.getId())
                .unitPrice(reserveRecordVO.getUnitPrice())
                .totalPrice(reserveRecordVO.getTotalPrice())
                .currentReserve(reserveRecordVO.getCurrentReserve())
                .currentTotalPrice(reserveRecordVO.getCurrentTotalPrice())
                .createTime(reserveRecordVO.getCreateTime())
                .updateTime(reserveRecordVO.getUpdateTime())
                .build();
        return reserveRecord;
    }

    public static List<MedicinalReserveRecord> reserveRecordVOS2ReserveRecords(List<MedicinalReserveRecordVO> reserveRecordVOS) {
        List<MedicinalReserveRecord> result = new ArrayList<>();
        Optional.of(reserveRecordVOS).ifPresent(list->list.forEach(recordVO->result.add(reserveRecordVO2ReserveRecord(recordVO))));
        return result;
    }

}
