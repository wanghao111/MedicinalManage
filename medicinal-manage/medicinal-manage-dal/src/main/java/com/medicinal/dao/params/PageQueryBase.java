package com.medicinal.dao.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class PageQueryBase {

    private int page;

    private int pageSize;

}
