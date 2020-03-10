package com.xjtuse.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class XjtuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(XjtuseApplication.class, args);
	}

}
