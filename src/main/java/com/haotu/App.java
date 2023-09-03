package com.haotu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
		for (String beanDefinitionName : ctx.getBeanFactory().getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}

}
