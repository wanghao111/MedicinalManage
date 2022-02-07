package com.medicinal.biz.converter;

import com.medicinal.biz.model.MedicinalReserveStatistics;
import com.medicinal.dao.vo.MedicinalReserveStatisticsVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicinalReserveStaConverter {

    public static MedicinalReserveStatistics reserveStasVO2ReserveStas(MedicinalReserveStatisticsVO reserveStatisticsVO) {
        MedicinalReserveStatistics statistics = MedicinalReserveStatistics.builder()
                .medicinalCode(reserveStatisticsVO.getMedicinalCode())
                .medicinalName(reserveStatisticsVO.getMedicinalName())
                .count(reserveStatisticsVO.getCount())
                .reserveType(reserveStatisticsVO.getReserveType())
                .totalPrice(reserveStatisticsVO.getTotalPrice())
                .build();
        return statistics;
    }


    public static List<MedicinalReserveStatistics> reserveStasListVO2ReserveStasList(List<MedicinalReserveStatisticsVO> reserveStatisticsVOList){
        List<MedicinalReserveStatistics> result = new ArrayList<>();
        Optional.of(reserveStatisticsVOList).ifPresent(list->
                list.forEach(entry->result.add(reserveStasVO2ReserveStas(entry)))
                );
        return result;
    }
}
