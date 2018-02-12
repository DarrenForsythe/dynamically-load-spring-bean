package com.darrenforsythe.boot.registerdynamicbeans;

import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import com.darrenforsythe.boot.registerdynamicbeans.aware.Aware;

/**
 * Loads Aware Beans.
 * 
 * @author Darren Forsythe
 *
 */
@Configuration
public class AwareConfig implements BeanDefinitionRegistryPostProcessor {

	private static final Logger LOG = LoggerFactory.getLogger(AwareConfig.class);

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		Reflections reflections = new Reflections(this.getClass().getPackage().getName());
		Set<Class<? extends Aware>> classes = reflections.getSubTypesOf(Aware.class);

		classes.stream().forEach(clazz -> {
			try {
				BeanDefinitionBuilder builder = BeanDefinitionBuilder
						.genericBeanDefinition(Class.forName(clazz.getName())).setLazyInit(false);
				((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(clazz.getName(),
						builder.getBeanDefinition());
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException(e);
			}
			LOG.info("Creating - {} bean", clazz.getName());
		});
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry arg0) throws BeansException {
		//NoOp
	}
}
