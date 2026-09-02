package com.own.eosp;

import com.own.eosp.model.Address;
import com.own.eosp.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EngineeringOnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineeringOnSpringBootApplication.class, args);


		ApplicationContext ct = new ClassPathXmlApplicationContext("our_beans.xml");
		Student student = ct.getBean(Student.class);
		System.out.println(student.getAddress());
//		Student student = new Student("John Doe", new Address());
//		System.out.println(student.getName());
	}

}