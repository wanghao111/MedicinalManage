package com.medicinal.biz.enums;

import lombok.Getter;

@Getter
public enum ReserveType {


    ADD_RESERVE(1,"增加库存"),
    DEL_RESERVE(2,"扣减库存"),
    ;

    private Integer type;

    private String msg;

    private ReserveType(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }


}
