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

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultBootSetupApplicationTests {
	
	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {
		
		assertThat(context.getBean(AwareServiceOne.class)).isNotNull();
		assertThat(context.getBean(AwareServiceTwo.class)).isNotNull();
		
		AwareService service = context.getBean(AwareServiceOne.class);
		assertThat(service.work()).isEqualTo("one");
		service = context.getBean(AwareServiceTwo.class);
		assertThat(service.work()).isEqualTo("two");
	}

}
