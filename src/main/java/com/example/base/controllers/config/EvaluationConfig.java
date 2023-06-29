package com.example.base.controllers.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@ConfigurationProperties(prefix="evaluation.service")
@Getter
@Slf4j
public class EvaluationConfig {
	
	private String authurl;
	
	private String aluminiurl;
	
	@PostConstruct
	public void postBeanConstruct() {
		
		log.info("authurl {}",authurl);
		
	}
		
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}	

}

