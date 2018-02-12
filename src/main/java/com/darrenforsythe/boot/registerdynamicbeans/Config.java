package com.darrenforsythe.boot.registerdynamicbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.darrenforsythe.boot.registerdynamicbeans.normal.Service;

/**
 * Normal configuration
 * @author Darren Forsythe
 *
 */
@Configuration
public class Config {
	
	@Bean
	public Service service() {
		return new Service();
	}

}
