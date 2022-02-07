package com.medicinal.web.controller;

import com.medicinal.biz.model.MedicinalBuyRecord;
import com.medicinal.biz.service.MedicinalBuyRecordService;
import com.medicinal.dao.params.MedicinalBuyRecordPageQuery;
import com.medicinal.web.converter.MedicinalBuyerRecordConverter;
import com.medicinal.web.dto.*;
import com.medicinal.web.factory.BaseResultFactory;
import com.medicinal.web.factory.PageQueryFacotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicinalBuyRecord")
public class MedicinalBuyRecordController {

    @Autowired
    private MedicinalBuyRecordService medicinalBuyRecordService;

    @PostMapping(value = "/create", produces = {"application/json;charset=utf-8"})
    public BaseResult<Integer> createMedicinalBuyRecord(@RequestBody MedicinalBuyRecordDTO medicinalBuyRecord) {
        int insertNum = medicinalBuyRecordService.create(MedicinalBuyerRecordConverter.buyRecordDTO2BuyRecord(medicinalBuyRecord));
        return BaseResultFactory.createSuccessBaseResult(insertNum, "create Medicinal buy record success");
    }

    @PostMapping(value = "/list", produces = {"application/json;charset=utf-8"})
    public BaseResult<PageResultBase> queryList(@RequestBody MedicinalBuyRecordPageParam param) {
        MedicinalBuyRecordPageQuery queryParam = PageQueryFacotry.buyerRecordPageRequestParam2Query(param);

        int totalCount = medicinalBuyRecordService.getTotalCount(queryParam);
        List<MedicinalBuyRecord> medicinalBuyRecords = medicinalBuyRecordService.queryList(queryParam);

        double totalPage = Math.ceil((double)totalCount / param.getPageSize());
        PageResultBase pageResultBase = PageResultBase.builder()
                .list(medicinalBuyRecords)
                .currentPage(param.getPage())
                .totalPage((int)totalPage)
                .build();
        return BaseResultFactory.createSuccessBaseResult(pageResultBase,"query success");
    }

}
