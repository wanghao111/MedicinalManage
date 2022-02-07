package com.medicinal.dao.params;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicinalReserveRecordPageQuery extends PageQueryBase {

    private String medicinalCode;

    private String medicinalName;
}
