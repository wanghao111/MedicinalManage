package com.medicinal.web.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wanghao
 * @version 1.0
 * @date 2022/5/15 15:00
 */
@Data
public class MedicinalSellSummaryDTO {

    private String buyerNumber;

    private String buyerName;

    private float totalPrice;

    private String month;

}
