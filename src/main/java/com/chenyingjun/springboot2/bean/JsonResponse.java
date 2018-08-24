package com.chenyingjun.springboot2.bean;

import com.chenyingjun.springboot2.exception.BusinessException;
import com.chenyingjun.springboot2.utils.LoggerUtil;
import lombok.Data;

import static com.chenyingjun.springboot2.constant.ExceptionConsts.EXCEPTION_SYSTEM;

/**
 * 标识返回的是Json数据
 *
 * @author chenyingjun
 * @since 1.0.0
 *
 */
@Data
public class JsonResponse {

    private int code;

    private String message;

    private Object data;

    public JsonResponse() {
        super();
    }

    public JsonResponse(Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            this.code = businessException.getCode();
            this.message = businessException.getMessage();
        } else {
            this.code = EXCEPTION_SYSTEM;
            this.message = "系统发生错误，请联系管理员";
            LoggerUtil.error(getClass(), "系统发生错误" + exception);
        }

    }

    public JsonResponse(Object data) {
        this.code = 200;
        this.message = "请求成功";
        this.data = data;
    }



    public boolean success() {
        return this.code == 200;
    }

    public boolean authorizationError() {
        return this.code == 401;
    }

}
