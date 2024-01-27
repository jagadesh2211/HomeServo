package com.jsp.homeservo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class HomeServoConfig {
		@Bean
		public Docket getDocket() {
			springfox.documentation.service.Contact contact=new springfox.documentation.service.Contact("Jspiders","www.jspiders.com", "jsp@gmail.com");
			List<VendorExtension>extensions=new ArrayList<>();
			
			ApiInfo apiInfo=new ApiInfo("HomeServo","SiteForVendors","Version 1.0", "Terms&Conditions",
					contact, "License", "url", extensions);
			
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.jsp.homeservo")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
		
		}

}
