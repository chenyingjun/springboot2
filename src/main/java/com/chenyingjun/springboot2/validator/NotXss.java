package com.chenyingjun.springboot2.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Title: NotXss.java
 * @Package com.red.p2p.validator
 * @Description: XSS验证注解
 * @author: chenyingjun
 * @date: 2017年8月24日
 * @version V1.0
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotXssValidator.class)
@Documented
public @interface NotXss {

    /** 默认错误消息 */
    String message() default "{notXss.message}";

    /** 分组 */
    Class<?>[]groups() default {};

    /**
     * maxLength 字符串最大长度 为0则不限制
     * 
     * @return
     */
    int maxLength() default 0;

    /**
     * minLength 字符串最小长度 为0则不限制
     * 
     * @return
     */
    int minLength() default 0;

    /** 负载 */
    Class<? extends Payload>[]payload() default {};

    /** 指定多个时使用 */
    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        NotXss[]value();
    }
}
