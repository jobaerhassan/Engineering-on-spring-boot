package com.own.eosp;

import com.own.eosp.model.Address;
import com.own.eosp.model.Student;
import com.own.eosp.model.TimedBean;
import com.own.eosp.scope.TimedScope;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication // have to use this in order to use annotation based application context
public class EngineeringOnSpringBootApplication {

	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(EngineeringOnSpringBootApplication.class);

		context.getBeanFactory().registerScope("timed", new TimedScope());

		System.out.println(context.getBean(TimedBean.class));
		Thread.sleep(2000);
		System.out.println(context.getBean(TimedBean.class));
		Thread.sleep(3000);
		System.out.println(context.getBean(TimedBean.class));
		Thread.sleep(5000);
		System.out.println(context.getBean(TimedBean.class));


	}

}
