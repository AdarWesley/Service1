package com.awesley.samples.Service1;

import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, 
		DataSourceProcessEngineAutoConfiguration.class})
public class Service1Application
{
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
