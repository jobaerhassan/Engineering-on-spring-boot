package com.own.eosp;

import com.own.eosp.event.GreetingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EngineeringOnSpringBootApplication implements CommandLineRunner {

	@Autowired
	private ApplicationEventPublisher publisher;
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(EngineeringOnSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		publisher.publishEvent(new GreetingEvent("Hello World"));
		Image image = new ProxyImage("photo.jpg");

		// এই লাইনে এসে ইমেজটি লোড হবে এবং ডিসপ্লে হবে
		image.display();
	}

}

