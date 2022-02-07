package com.medicinal.dao.params;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicinalBuyRecordPageQuery  extends PageQueryBase {
    private String medicinalCode;

    private String medicinalName;

    private String buyerName;

    private Integer buyerNumber;

}
