package com.qsp.springboot_employee.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
//                                     name           url                 email
		Contact contact = new Contact("Qspider", "http://qspider.com", "sarang@gmail.com");
		
		List<VendorExtension> extensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("Employee management", "EM version 1.2", "Version 1.0", "1 year Free Service" ,
				contact, "QWERTY1234", "http://QWERTY1234.com\",\"sarang@gmail.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_employee")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
