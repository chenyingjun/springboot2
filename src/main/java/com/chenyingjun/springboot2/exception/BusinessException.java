package com.chenyingjun.springboot2.exception;


import com.chenyingjun.springboot2.bean.ExceptionType;

import static com.chenyingjun.springboot2.constant.ExceptionConsts.EXCEPTION_BUSINESS;

/**
 * 业务异常
 *
 * @author chenyingjun
 * @since 1.0.0
 *
 * @see ExceptionType
 */
public class BusinessException extends RuntimeException {

    private int code;

    private String message;

    public BusinessException(String message) {
        this.code = EXCEPTION_BUSINESS;
        this.message = message;
    }

    public BusinessException(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public BusinessException(ExceptionType exceptionType) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
