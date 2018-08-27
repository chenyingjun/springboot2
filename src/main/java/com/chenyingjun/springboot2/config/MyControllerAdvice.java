package com.chenyingjun.springboot2.config;

import com.chenyingjun.springboot2.bean.JsonResponse;
import com.chenyingjun.springboot2.exception.BusinessException;
import com.chenyingjun.springboot2.utils.FormValidUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static com.chenyingjun.springboot2.constant.ExceptionConsts.EXCEPTION_FORM_VALID;

/**
 * 返回异常及数据拦截类
 *
 * @author chenyingjun
 * @version 2017年12月27日
 * @since 1.0
 */
@ControllerAdvice
public class MyControllerAdvice implements ResponseBodyAdvice<Object>{

    /**
     * 全局异常捕捉处理
     * @param ex 全局异常
     * @return 异常封装
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JsonResponse errorHandler(Exception ex) {
        return new JsonResponse(ex);
    }

    /**
     * 拦截捕捉自定义事务异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public JsonResponse businessErrorHandler(BusinessException ex) {
        return new JsonResponse(ex);
    }

    /**
     * 拦截捕捉参数校验异常 BindException.class
     * @param ex 参数校验异常
     * @return 异常封装
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JsonResponse validateErrorHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return bindingResult(bindingResult);
    }
    /**
     * 拦截捕捉参数校验异常 BindException.class
     * @param ex 参数校验异常
     * @return 异常封装
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public JsonResponse validateErrorHandler(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return bindingResult(bindingResult);
    }

    /**
     *  异常封装
     * @param bindingResult 参数效验情况
     * @return 异常封装
     */
    private JsonResponse bindingResult(BindingResult bindingResult) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(EXCEPTION_FORM_VALID);
        if (bindingResult.hasErrors()) {
            FormValidUtil formValid = new FormValidUtil(bindingResult);
            jsonResponse.setData(formValid);
            jsonResponse.setMessage("参数错误");
        } else {
            jsonResponse.setMessage("未知参数校验错误");
        }
        return jsonResponse;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String requestPath = request.getURI().getPath();
        //过滤掉swagger显示界面的请求
        if (requestPath.indexOf("swagger") >= 0 || requestPath.indexOf("/api-docs") >= 0) {
            return body;
        }

        //本来封装好的不再进行二次封装
        if (body instanceof JsonResponse) {
            return body;
        }

        //返回url
        if (body instanceof ModelAndView) {
            return body;
        }
        return new JsonResponse(body);
    }
}
