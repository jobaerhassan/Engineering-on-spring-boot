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

		ApplicationContext context =
				new AnnotationConfigApplicationContext(EngineeringOnSpringBootApplication.class);

//		Address a = context.getBean("address", Address.class);
//		System.out.println("getBean(address) → " + a);

		Student s = context.getBean( Student.class);
		System.out.println(s);


	}

}
