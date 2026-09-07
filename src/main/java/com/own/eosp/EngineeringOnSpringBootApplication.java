package com.own.eosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication // have to use this in order to use annotation based application context
public class EngineeringOnSpringBootApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(EngineeringOnSpringBootApplication.class, args);
		String s = context.getMessage("hello.world", null, null, null);
		System.out.println(s);
	}

}
