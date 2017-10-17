package com.wtc.admin.performance.config;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class WebConfig {
	
	@Bean
	public ErrorPageRegistrar errorPageRegistrar(){
		return new MyErrorPageRegistrar();
	}
	
	private static class MyErrorPageRegistrar implements ErrorPageRegistrar {
		
		@Override
		public void registerErrorPages(ErrorPageRegistry registry) {
			registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index"));
		}
		
	}
}
