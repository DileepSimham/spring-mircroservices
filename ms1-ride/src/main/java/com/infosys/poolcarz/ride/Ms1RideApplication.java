package com.infosys.poolcarz.ride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Ms1RideApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms1RideApplication.class, args);
	}


	@Bean @LoadBalanced
	public RestTemplate template(){
		return new RestTemplate();
	}

}
