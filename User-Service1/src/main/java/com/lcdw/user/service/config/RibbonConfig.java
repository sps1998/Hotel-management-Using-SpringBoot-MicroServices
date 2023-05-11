package com.lcdw.user.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RibbonConfig {
	/*
	Use @RibbonClient(name = "name of service with many variant", thisclass.class) at controller class
	
	Three rules are there
	1.RoundRobinRule
	2. RoundRobinRule
	3.WeightedResponseTimeRule
	
	*/
	
	
	/*
	@Autowired
	IClientConfig ribbonClient;
	
	@Bean
	public IRule ribbonRule( ) {
		return new AvailabilityFilteringRule();
	}

	@Bean
	public IPing ribbonPing() {
		return new PingUrl();
	}
	
	
	
	*/
	
	

	
}



