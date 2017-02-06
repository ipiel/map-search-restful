package com.example;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MapSearchRestfulApplication {
	private ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MapSearchRestfulApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		registration.addUrlMappings("/console/*");
		
		return registration;
	}
}
