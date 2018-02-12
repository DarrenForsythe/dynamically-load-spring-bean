package com.darrenforsythe.boot.registerdynamicbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareServiceOne;
import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareServiceTwo;
import com.darrenforsythe.boot.registerdynamicbeans.normal.Service;

/**
 * Normal configuration
 * 
 * @author Darren Forsythe
 *
 */
@Configuration
public class Config {

	@Bean
	public Service service(AwareServiceOne one, AwareServiceTwo two) {
		return new Service(one, two);
	}

}
