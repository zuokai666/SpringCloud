package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudNode1App {
	
	public static void main(String[] args) {
		SpringApplication.run(CloudNode1App.class, args);
	}
}