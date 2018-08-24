package com.chenyingjun.springboot2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 配置参数信息
 * @author chenyingjun
 * @date 2018年8月24日
 */
public class PropertiesLoaderUtil {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(PropertiesLoaderUtil.class);

    /**
     * properties
     */
    private MutablePropertySources propertySources;

    /**
     * 加载配置信息
     */
    public PropertiesLoaderUtil() {
        try {
            this.propertySources = (MutablePropertySources) SpringContextUtil.getBean("configGroupSources");
        } catch (Exception var3) {
            logger.error("没有配置统一配置服务");
        }
    }

    /**
     * 根据key值获取配置信息
     * @param key key
     * @return 配置信息
     */
    private String getValue(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        } else {
            if (this.propertySources != null) {
                Iterator iter = this.propertySources.iterator();

                while(iter.hasNext()) {
                    PropertySource<?> str = (PropertySource)iter.next();
                    if (str.containsProperty(key)) {
                        return str.getProperty(key).toString();
                    }
                }
            }
            return null;
        }
    }

    /**
     * 根据key值获取配置信息
     * @param key key
     * @return 配置信息
     */
    public String getProperty(String key) {
        String value = this.getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        } else {
            return value;
        }
    }

    /**
     * 根据key值获取配置信息
     * @param key key
     * @param defaultValue 默认值
     * @return 配置信息
     */
    public String getProperty(String key, String defaultValue) {
        String value = this.getValue(key);
        return value != null ? value : defaultValue;
    }
}
