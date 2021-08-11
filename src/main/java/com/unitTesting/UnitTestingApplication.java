package com.unitTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.unitTesting"})
public class UnitTestingApplication {
	private static ApplicationContext applicationContext;


	public static void main(String[] args) {
		applicationContext=SpringApplication.run(UnitTestingApplication.class, args);
		checkBeansPresence(
				"bean1","bean2");
	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " +
					applicationContext.containsBean(beanName));
		}
	}

}
