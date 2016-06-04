package com.awesley.samples.Service1;

import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.internetitem.spring.cxf.CxfConfiguration;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, 
		DataSourceProcessEngineAutoConfiguration.class})
@ComponentScan
@Import(value = { CxfConfiguration.class})
public class Service1ApplicationConfig {

}
