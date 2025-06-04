package com.multitap.feedbackquery.common.exception;

import com.multitap.feedbackquery.common.response.BaseResponseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final BaseResponseStatus status;

    public BaseException(BaseResponseStatus status) {
        this.status = status;

    }
}
