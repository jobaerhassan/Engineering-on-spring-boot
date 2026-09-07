package com.own.eosp;

import com.own.eosp.event.GreetingEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication // have to use this in order to use annotation based application context
public class EngineeringOnSpringBootApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(EngineeringOnSpringBootApplication.class, args);
		context.publishEvent(new GreetingEvent("hello from jobaer"));
	}

}
