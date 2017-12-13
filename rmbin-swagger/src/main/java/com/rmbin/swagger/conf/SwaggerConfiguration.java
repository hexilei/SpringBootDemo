package com.rmbin.swagger.conf;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	public Docket createRestApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("cn.timebusker")).paths(PathSelectors.any()).build();
	}
	
	public ApiInfo apiInfo()
	{
		Contact contact = new Contact("rmbin", "hebing_o@hotmail.com", "183038681");
		return new ApiInfoBuilder()
		           .title("Spring Boot中使用Swagger2构建RESTful APIs")
		           .description("SpringBoot integration")
		           .termsOfServiceUrl("https://github.com/timebusker/spring-boot/tree/master/spring-boot-12-Swagger2/")
		           .contact(contact)
		           .version("2.0.0")
		           .build();
	}

}
