package com.own.eosp;

import com.own.eosp.model.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
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
		System.out.println(student.getName());
	}

}


//class CustomScope implements Scope {
//
//	@Override
//	public Object get(String name, ObjectFactory<?> objectFactory) {
//		return null;
//	}
//
//	@Override
//	public @Nullable Object remove(String name) {
//		return null;
//	}
//
//	@Override
//	public void registerDestructionCallback(String name, Runnable callback) {
//
//	}
//
//	@Override
//	public @Nullable Object resolveContextualObject(String key) {
//		return Scope.super.resolveContextualObject(key);
//	}
//
//	@Override
//	public @Nullable String getConversationId() {
//		return Scope.super.getConversationId();
//	}
//}