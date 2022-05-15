package com.medicinal.dao.params;

import lombok.Data;

/**
 * @author wanghao
 * @version 1.0
 * @date 2022/5/14 20:36
 */
@Data
public class MedicinalSummaryRecorePageQuery extends PageQueryBase{


    private String medicinalCode;

    private String medicinalName;

}
