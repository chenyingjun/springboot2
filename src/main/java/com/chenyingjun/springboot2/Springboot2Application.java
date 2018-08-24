package com.chenyingjun.springboot2;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * springboot2启动
 *
 * @author  chenyingjun
 * @Date 2018年08月21日
 * @since 1.0
 */
@SpringBootApplication
@EnableSwagger2
@ImportResource(value = { "classpath:applicationContext*.xml" })
@MapperScan("com.chenyingjun.springboot2.mapper")
public class Springboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}

	/**
	 * SWAGGER_2
	 *
	 * @return Docket
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.chenyingjun.springboot2.rest")).paths(PathSelectors.any()).build()
				.ignoredParameterTypes(ApiIgnore.class);
	}

	/**
	 * ApiInfo
	 *
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("应用 APIs").version("1.0").build();
	}
}
