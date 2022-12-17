package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication

public class ProductManagementMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementMvcApplication.class, args);
	}

}
