package com.bjbt.monitoring.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bjbt.monitoring.generator.dao")
public class MonitoringGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringGeneratorApplication.class, args);
	}
}
