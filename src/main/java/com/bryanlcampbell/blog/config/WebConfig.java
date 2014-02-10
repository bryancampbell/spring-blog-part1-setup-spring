package com.bryanlcampbell.blog.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Value("${service.port}")
	private Integer servicePort;
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(servicePort);
		factory.setSessionTimeout(10, TimeUnit.MINUTES);
		factory.addErrorPages(
				new ErrorPage(HttpStatus.BAD_REQUEST, "/not-found"), 
				new ErrorPage(HttpStatus.FORBIDDEN, "/not-found"), 
				new ErrorPage(HttpStatus.NOT_FOUND, "/not-found"), 
				new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/not-found")
		);
		return factory;
	}

}
