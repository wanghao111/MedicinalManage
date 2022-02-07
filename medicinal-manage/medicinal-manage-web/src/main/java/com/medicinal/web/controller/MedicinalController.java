package com.medicinal.web.controller;

import com.medicinal.biz.enums.ReserveType;
import com.medicinal.biz.model.Medicinal;
import com.medicinal.biz.model.MedicinalReserveRecord;
import com.medicinal.biz.model.MedicinalReserveStatistics;
import com.medicinal.biz.model.MedicinalStatisticsEntry;
import com.medicinal.biz.service.MedicinalService;
import com.medicinal.biz.service.MedicinalStatisticsService;
import com.medicinal.dao.params.MedicinalPageQueryParam;
import com.medicinal.dao.params.MedicinalReserveRecordPageQuery;
import com.medicinal.dao.params.MedicinalStatisticsPageQuery;
import com.medicinal.web.converter.MedicinalConverter;
import com.medicinal.web.converter.MedicinalRecordStatsConverter;
import com.medicinal.web.dto.*;
import com.medicinal.web.factory.BaseResultFactory;
import com.medicinal.web.factory.PageQueryFacotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicinal")
public class MedicinalController {

    @Autowired
    private MedicinalService medicinalService;

    @Autowired
    private MedicinalStatisticsService medicinalStatisticsService;

    private List<Medicinal> medicinals = new ArrayList<>();

    @PostMapping(value = "/create", produces = {"application/json;charset=utf-8"})
    public BaseResult<Integer> createMedicinal(@RequestBody MedicinalDTO params) {
        int insertNum = medicinalService.create(MedicinalConverter.medicinalDTO2Medicinal(params));
        return BaseResultFactory.createSuccessBaseResult(insertNum, "create Medicinal success");
    }

    @PostMapping(value = "/update", produces = {"application/json;charset=utf-8"})
    public BaseResult<List> updateMedicinal(@RequestBody MedicinalDTO params) {
        int insertNum = medicinalService.update(MedicinalConverter.medicinalDTO2Medicinal(params));
        return BaseResultFactory.createSuccessBaseResult(insertNum, "update Medicinal success");
    }

    @GetMapping(value = "/delete")
    public BaseResult<List> deleteMedicinal(@RequestParam String code) {
        int deleteNum = medicinalService.delete(code);
        return BaseResultFactory.createSuccessBaseResult(deleteNum,"delete success");
    }

    @PostMapping(value = "/list", produces = {"application/json;charset=utf-8"})
    public BaseResult<PageResultBase> queryList(@RequestBody MedicinalPageRequestParam param) {
        MedicinalPageQueryParam queryParam = PageQueryFacotry.MedicinalPageRequestParam2Query(param);


        int totalCount = medicinalService.getTotalCount(queryParam);
        List<Medicinal> medicinals = medicinalService.queryList(queryParam);

        double totalPage = Math.ceil((double)totalCount / param.getPageSize());
        PageResultBase pageResultBase = PageResultBase.builder()
                .list(medicinals)
                .currentPage(param.getPage())
                .totalPage((int)totalPage)
                .build();
        return BaseResultFactory.createSuccessBaseResult(pageResultBase,"query success");
    }

    @PostMapping(value = "/reserveRecord/list", produces = {"application/json;charset=utf-8"})
    public BaseResult<PageResultBase> queryReserveRecordList(@RequestBody MedicinalReserveRecordPageParam param) {
        MedicinalReserveRecordPageQuery queryParam = PageQueryFacotry.reserveRecordPageRequestParam2Query(param);


        int totalCount = medicinalService.getReserveRecordTotalCount(queryParam);
        List<MedicinalReserveRecord> medicinalReserveRecords = medicinalService.queryReserveRecordList(queryParam);

        double totalPage = Math.ceil((double)totalCount / param.getPageSize());
        PageResultBase pageResultBase = PageResultBase.builder()
                .list(medicinalReserveRecords)
                .currentPage(param.getPage())
                .totalPage((int)totalPage)
                .build();
        return BaseResultFactory.createSuccessBaseResult(pageResultBase,"query success");
    }

    @PostMapping(value = "/reserveRecordStats/list", produces = {"application/json;charset=utf-8"})
    public BaseResult<PageResultBase> pageMedicinalReserveStas(@RequestBody MedicinalReserveStasPageParam param) {
        if(null == param || StringUtils.isEmpty(param.getMonth())) {
//            PageResultBase pageResultBase = new PageResultBase();
            BaseResult<PageResultBase> result = new BaseResult<>();
            result.setCode(-1);
            result.setData(null);
            result.setMessage("请输入查询月份");
            return result;
        }
        int distinctTotalCountByMonth = medicinalStatisticsService.getDistinctTotalCountByMonth(param.getMonth());
        if (distinctTotalCountByMonth == 0) {
            PageResultBase pageResultBase = PageResultBase.builder()
                    .list(new ArrayList<>())
                    .currentPage(param.getPage())
                    .totalPage(0)
                    .build();
            return BaseResultFactory.createSuccessBaseResult(pageResultBase,"query stats success");
        }
        MedicinalStatisticsPageQuery query = MedicinalRecordStatsConverter.reserveStasPageParam2statisticsPageQuery(param);
        List<String> medicinalCodes = medicinalStatisticsService.pageQueryDistinctMedicinal(query);
        if (CollectionUtils.isEmpty(medicinalCodes)) {
            PageResultBase pageResultBase = PageResultBase.builder()
                    .list(new ArrayList<>())
                    .currentPage(param.getPage())
                    .totalPage(0)
                    .build();
            return BaseResultFactory.createSuccessBaseResult(pageResultBase,"query stats success");
        }

        List<MedicinalReserveStatistics> medicinalReserveStatistics = medicinalStatisticsService.queryRecordStatisticsListByMonth(query.getMonth(), medicinalCodes);
        Map<String, List<MedicinalReserveStatistics>> reserveStatsMap = new HashMap<>();
        Optional.of(medicinalReserveStatistics).ifPresent(reserveStatsList->reserveStatsList.forEach(reserveStats->{
            if(!reserveStatsMap.containsKey(reserveStats.getMedicinalCode())) {
                List<MedicinalReserveStatistics> tmpList = new ArrayList<>();
                tmpList.add(reserveStats);
                reserveStatsMap.put(reserveStats.getMedicinalCode(), tmpList);
            } else {
                reserveStatsMap.get(reserveStats.getMedicinalCode()).add(reserveStats);
            }
        }));

        List<MedicinalReserveRecord> lastRecords = medicinalStatisticsService.getLastRecord(query.getMonth(), medicinalCodes);
        Map<String, MedicinalReserveRecord> reserveRecordMap = Optional.of(lastRecords).orElse(new ArrayList<>())
                .stream()
                .collect(Collectors.toMap(MedicinalReserveRecord::getMedicinalCode, r -> r));

        List<MedicinalReserveRecord> preMonthLastRecords = medicinalStatisticsService.getLastRecord(getPreMonth(query.getMonth()), medicinalCodes);
        Map<String, MedicinalReserveRecord> preReserveRecordMap = Optional.of(preMonthLastRecords).orElse(new ArrayList<>())
                .stream()
                .collect(Collectors.toMap(MedicinalReserveRecord::getMedicinalCode, r -> r));

        List<MedicinalStatisticsEntry> entryList = new ArrayList<>();

        Optional.of(medicinalCodes).ifPresent(mcodes->mcodes.forEach(medicinalCode->{
            MedicinalReserveRecord reserveRecord = reserveRecordMap.get(medicinalCode);
            List<MedicinalReserveStatistics> stats = reserveStatsMap.get(medicinalCode);
            MedicinalReserveRecord preReserveRecord = preReserveRecordMap.get(medicinalCode);

            if (null == reserveRecord && CollectionUtils.isEmpty(stats) && null == preReserveRecord ) {
                return;
            }

            MedicinalStatisticsEntry statsEntry = new MedicinalStatisticsEntry();
            statsEntry.setMedicinalCode(medicinalCode);
            if (null != reserveRecord) {
                statsEntry.setMedicinalName(reserveRecord.getMedicinalName());
                statsEntry.setUnitPrice(reserveRecord.getUnitPrice());

                statsEntry.setCurrentReserve(reserveRecord.getCurrentReserve());
                statsEntry.setCurrentTotalPrice(reserveRecord.getCurrentTotalPrice());
            }

            if (!CollectionUtils.isEmpty(stats)) {
                stats.forEach(reserveStats->{
                    if (ReserveType.ADD_RESERVE.getType().equals(reserveStats.getReserveType())) {
                        statsEntry.setCurrentMonthAddCount(reserveStats.getCount());
                        statsEntry.setCurrentMonthAddTotalPrice(reserveStats.getTotalPrice());
                    } else if (ReserveType.DEL_RESERVE.getType().equals(reserveStats.getReserveType())) {
                        statsEntry.setCurrentMonthSaleCount(reserveStats.getCount());
                        statsEntry.setCurrentMonthSaleTotalPrice(reserveStats.getTotalPrice());
                    }
                });
            }

            if (null != preReserveRecord) {
                statsEntry.setPreMonthSurplusCount(preReserveRecord.getCurrentReserve());
                statsEntry.setPreMonthSurplusTotalPrice(preReserveRecord.getCurrentTotalPrice());
            }

            entryList.add(statsEntry);
        }));

        double totalPage = Math.ceil((double)distinctTotalCountByMonth / param.getPageSize());
        PageResultBase pageResultBase = PageResultBase.builder()
                .list(entryList)
                .currentPage(param.getPage())
                .totalPage((int)totalPage)
                .build();
        return BaseResultFactory.createSuccessBaseResult(pageResultBase,"query stats success");
    }


    private String getPreMonth(String currentMonth) {
        Pattern compile = Pattern.compile("([0-9]{4})-([0-9]{2})");
        Matcher matcher = compile.matcher(currentMonth);
        if(matcher.find()) {
            Integer year = Integer.parseInt(matcher.group(1));
            Integer month = Integer.parseInt(matcher.group(2));


            if (month >= 11) {
                return year + "-" +(month - 1);
            } else if (month > 1) {
                return year + "-0" +(month - 1);
            } else {
                return (year - 1) + "-" + 12;
            }
        }
        return "";
    }

}
