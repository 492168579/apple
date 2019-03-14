package com.yzy.apple.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringCloudApplication
@EnableEurekaServer
public class AppleEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppleEurekaApplication.class, args);
	}
}
