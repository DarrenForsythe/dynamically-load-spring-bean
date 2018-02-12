package com.darrenforsythe.boot.registerdynamicbeans;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareService;
import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareServiceOne;
import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareServiceTwo;
import com.darrenforsythe.boot.registerdynamicbeans.normal.Service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultBootSetupApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private Service service;

	@Test
	public void contextLoads() {

		assertThat(context.getBean(AwareServiceOne.class)).isNotNull();
		assertThat(context.getBean(AwareServiceTwo.class)).isNotNull();

		AwareService awareService = context.getBean(AwareServiceOne.class);
		assertThat(awareService.work()).isEqualTo("one");
		awareService = context.getBean(AwareServiceTwo.class);
		assertThat(awareService.work()).isEqualTo("two");

		assertThat(service.doThing()).isEqualTo("onetwothing");
	}

}
