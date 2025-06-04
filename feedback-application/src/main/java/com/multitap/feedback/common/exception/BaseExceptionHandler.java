package com.multitap.feedback.common.exception;

import com.multitap.feedback.common.response.BaseResponse;
import com.multitap.feedback.common.response.BaseResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<Void>> BaseError(BaseException e) {
        BaseResponse<Void> response = new BaseResponse<>(e.getStatus());
        log.error("BaseException -> {} {})", e.getStatus(), e.getStatus().getMessage(), e);
        return new ResponseEntity<>(response, response.httpStatus());
    }


    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<BaseResponse<Void>> handleRuntimeException(RuntimeException e) {

        BaseResponse<Void> response = new BaseResponse<>(BaseResponseStatus.INTERNAL_SERVER_ERROR);
        log.error("RuntimeException: ", e);
        for (StackTraceElement s : e.getStackTrace()) {
            System.out.println(s);
        }
        return new ResponseEntity<>(response, response.httpStatus());
    }
}
