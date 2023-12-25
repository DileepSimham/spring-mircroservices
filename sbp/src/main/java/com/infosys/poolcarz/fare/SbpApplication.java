package com.infosys.poolcarz.fare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.poolcarz.fare.dileep.MobileService;

@SpringBootApplication
public class SbpApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SbpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
		MobileService bean = (MobileService)context.getBean("mobileService3");
		
		System.out.println(bean.getModel());
	}
	
	

}
