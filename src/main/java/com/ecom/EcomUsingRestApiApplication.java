package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the application. Living in com.ecom, it component-scans the
 * controller, service and repository packages beneath it.
 */
@SpringBootApplication
public class EcomUsingRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomUsingRestApiApplication.class, args);
	}

}
