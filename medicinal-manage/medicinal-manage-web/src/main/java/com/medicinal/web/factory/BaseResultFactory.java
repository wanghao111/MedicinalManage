package com.medicinal.web.factory;

import com.medicinal.web.dto.BaseResult;
import org.springframework.util.StringUtils;

public class BaseResultFactory {

    public static BaseResult createSuccessBaseResult() {
        BaseResult baseResult = BaseResult.builder()
                .code(20000)
                .message("success")
                .build();
        return baseResult;
    }

    public static <T> BaseResult createSuccessBaseResult(T data, String msg) {
        BaseResult baseResult = BaseResult.builder()
                .code(20000)
//                .message("success")
                .data(data)
                .build();
        if (StringUtils.isEmpty(msg)) {
            baseResult.setMessage("success");
        } else {
            baseResult.setMessage(msg);
        }
        return baseResult;
    }
}
