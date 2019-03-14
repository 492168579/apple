package com.yzy.apple.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认证授权中心
 * 
 * @author yezhaoyi
 *
 */
@SpringCloudApplication
@EnableAuthorizationServer
public class AppleAuthtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppleAuthtApplication.class, args);
	}
}
