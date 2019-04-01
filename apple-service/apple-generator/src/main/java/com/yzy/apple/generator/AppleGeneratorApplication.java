package com.yzy.apple.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yzy.apple.generator.dao")
public class AppleGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppleGeneratorApplication.class, args);
	}
}
