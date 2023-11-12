package com.socialmedia_solides.postssrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PostsSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostsSrvApplication.class, args);
	}

}
