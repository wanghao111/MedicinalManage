package com.medicinal.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResultBase<T> {

    private Integer currentPage;

    private Integer totalPage;

    private T list;
}
