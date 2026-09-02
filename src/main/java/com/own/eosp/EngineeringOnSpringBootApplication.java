package com.own.eosp;

import com.own.eosp.model.Address;
import com.own.eosp.model.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication // have to use this in order to use annotation based application context
public class EngineeringOnSpringBootApplication {

	public static void main(String[] args) {

		System.out.println("=== container start হচ্ছে... ===");
		ApplicationContext context =
				new AnnotationConfigApplicationContext(EngineeringOnSpringBootApplication.class);
		System.out.println("=== container ready. এখন getBean করব ===");

		Address a = context.getBean("address", Address.class);
		System.out.println("getBean(address) → " + a);

		Student s = context.getBean("stu", Student.class);
		System.out.println("getBean(stu) → " + s);


	}

}
