package com.socialmedia_solides.picturessrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PicturesSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicturesSrvApplication.class, args);
	}

}
