package com.medicinal.web.controller;

import com.medicinal.biz.model.Medicinal;
import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.web.converter.MedicinalConverter;
import com.medicinal.web.dto.BaseResult;
import com.medicinal.web.dto.MedicinalBuyDTO;
import com.medicinal.web.dto.MedicinalDTO;
import com.medicinal.web.factory.BaseResultFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 购药管理
 * @author wanghao
 * @version 1.0
 * @date 2022/5/14 14:41
 */
@RestController
@RequestMapping("/medicinal/buy")
public class MedicinalBuyController {

    public BaseResult<Integer> addMedicinalBuyOrder(@RequestBody MedicinalBuyDTO params) {
        MedicinalBuyRecord buyRecord = MedicinalBuyRecord.builder()
                .code(params.getCode())
                .count(params.getCount())
                .build();
        int insertNum = medicinalService.create(medicinal);
        return BaseResultFactory.createSuccessBaseResult(insertNum, "create Medicinal success");
    }




}
