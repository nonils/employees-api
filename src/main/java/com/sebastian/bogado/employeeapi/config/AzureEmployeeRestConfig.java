package com.sebastian.bogado.employeeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class AzureEmployeeRestConfig {
	@Bean
	public RestTemplate azureEmployeeRestTemplate() {
		RestTemplate rt = new RestTemplate();
		rt.setUriTemplateHandler(new DefaultUriBuilderFactory("http://masglobaltestapi.azurewebsites.net"));
		return rt;
	}
}
