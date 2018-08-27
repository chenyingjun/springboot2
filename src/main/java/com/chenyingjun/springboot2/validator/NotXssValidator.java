package com.chenyingjun.springboot2.validator;



import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @Title: NotXssValidator.java
 * @Package com.red.p2p.validator
 * @Description: XSS验证注解验证器
 * @author: chenyingjun
 * @date: 2017年8月24日
 * @version V1.0
 */
public class NotXssValidator implements ConstraintValidator<NotXss, String> {

    /** maxLength:最大长度 */
    private int maxLength;

    /** minLength:最小长度 */
    private int minLength;

    @Override
    public void initialize(NotXss constraintAnnotation) {
        this.maxLength = constraintAnnotation.maxLength();
        this.minLength = constraintAnnotation.minLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (StringUtils.isBlank(value)) {

            return true;
        }

        if (minLength > 0) {
            if (value.length() < minLength) {
                context.buildConstraintViolationWithTemplate("{data.minLength}").addConstraintViolation();
                return false;
            }
        }

        if (maxLength > 0) {
            if (value.length() > maxLength) {
                context.buildConstraintViolationWithTemplate("{data.maxLength}").addConstraintViolation();
                return false;
            }
        }

        boolean status = checkXss(value);

        return status;
    }

    /**
     * @Title: checkXss
     * @Description: 验证value是否包含Xss 包含返回false不包含返回true
     *
     * @return
     * @throws Exception
     */
    public static boolean checkXss(String value) {

        if (org.apache.commons.lang3.StringUtils.isBlank(value)) {

            return true;
        }

        // NOTE: It's highly recommended to use the ESAPI library and uncomment
        // the following line to
        // avoid encoded attacks.
        // value = ESAPI.encoder().canonicalize(value);
        // Avoid null characters
        // Avoid anything between script tags
        Pattern scriptPattern = compile("<script>(.*?)</script>", CASE_INSENSITIVE);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Avoid anything in a src="http://www.yihaomen.com/article/java/..."
        // type of e­xpression
        scriptPattern = compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", CASE_INSENSITIVE | MULTILINE
                | DOTALL);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        scriptPattern = compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", CASE_INSENSITIVE | MULTILINE
                | DOTALL);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }
        // Remove any lonesome </script> tag
        scriptPattern = compile("</script>", CASE_INSENSITIVE);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Remove any lonesome <script ...> tag
        scriptPattern = compile("<script(.*?)>", CASE_INSENSITIVE | MULTILINE | DOTALL);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Avoid eval(...) e­xpressions
        scriptPattern = compile("eval\\((.*?)\\)", CASE_INSENSITIVE | MULTILINE
                | DOTALL);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Avoid e­xpression(...) e­xpressions
        scriptPattern = compile("e­xpression\\((.*?)\\)", CASE_INSENSITIVE | MULTILINE
                | DOTALL);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Avoid javascript:... e­xpressions
        scriptPattern = compile("javascript:", CASE_INSENSITIVE);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Avoid vbscript:... e­xpressions
        scriptPattern = compile("vbscript:", CASE_INSENSITIVE);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        // Avoid onload= e­xpressions
        scriptPattern = compile("onload(.*?)=", CASE_INSENSITIVE | MULTILINE | DOTALL);

        if (scriptPattern.matcher(value).find()) {

            return false;
        }

        try {
            value = value.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            value = value.replaceAll("\\+", "%2B");
            String value_ = URLDecoder.decode(value, "UTF-8");

            scriptPattern = compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", CASE_INSENSITIVE
                    | MULTILINE | DOTALL);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", CASE_INSENSITIVE
                    | MULTILINE | DOTALL);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("</script>", CASE_INSENSITIVE);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("<script(.*?)>", CASE_INSENSITIVE | MULTILINE
                    | DOTALL);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("eval\\((.*?)\\)", CASE_INSENSITIVE | MULTILINE
                    | DOTALL);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("e­xpression\\((.*?)\\)", CASE_INSENSITIVE | MULTILINE
                    | DOTALL);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("javascript:", CASE_INSENSITIVE);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("vbscript:", CASE_INSENSITIVE);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

            scriptPattern = compile("onload(.*?)=", CASE_INSENSITIVE | MULTILINE
                    | DOTALL);

            if (scriptPattern.matcher(value_).find()) {

                return false;
            }

        } catch (UnsupportedEncodingException e) {

        }

        return true;
    }
}
