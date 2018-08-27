package com.chenyingjun.springboot2.config;

import com.chenyingjun.springboot2.utils.GlobalUtil;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * FreeMarker工具类配置
 * 
 * @author chenyingjun
 * @since 1.0
 * @version 2018年8月15日 chenyingjun
 */
@Component
public class MyFreeMarkerConfig {
    
    /** Logger */
    private final Logger logger = LoggerFactory.getLogger(MyFreeMarkerConfig.class);
    
    /** Configuration */
    @Autowired
    private Configuration freeMarkerConfiguration;
    
    /**
     * 配置工具类
     */
    @PostConstruct
    public void freemarkerConfig() {
        try {
            freeMarkerConfiguration.setSharedVariable("global", new GlobalUtil());
        } catch (TemplateModelException e) {
            logger.error(e.toString(), e);
        }
    }
    
}
