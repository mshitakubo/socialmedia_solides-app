package com.socialmedia_solides.oauthsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OauthSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthSrvApplication.class, args);
	}

}
