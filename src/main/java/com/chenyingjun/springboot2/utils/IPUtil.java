package com.chenyingjun.springboot2.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: IP工具类
 * @author: chenyingjun
 * @date: 2018年03月18日12:00:55
 * @version V1.0
 */
public abstract class IPUtil {

    /**
     * 
     * @Title: getRequestIP
     * @Description: 获取请求的IP地址
     * @param request
     *            请求
     * @return 请求IP地址
     */
    public static String getRequestIP(HttpServletRequest request) throws Exception {

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();
        }

        return ip;
    }

}