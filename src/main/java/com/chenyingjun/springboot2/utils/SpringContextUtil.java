package com.chenyingjun.springboot2.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * 静态获取Bean
 *
 * @author chenyingjun
 * @version 2018年08月24日
 * @since 1.0
 *
 */
@Configuration
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * 重写上下文信息
	 * @param applicationContext 上下文
	 * @throws BeansException e
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 获取上下文
	 * @return 上下文
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取指定的bean
	 * @param name bean名
	 * @return bean对象
	 * @throws BeansException e
	 */
	public static Object getBean(String name) throws BeansException {
		try {
			return applicationContext.getBean(name);
		} catch (Exception e) {
			throw new RuntimeException("获取的Bean不存在！");
		}
	}

	public static <T> T getBean(String name, Class<T> requiredType)
			throws BeansException {
		return applicationContext.getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.isSingleton(name);
	}

	public static Class<? extends Object> getType(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getType(name);
	}

	public static String[] getAliases(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getAliases(name);
	}

}