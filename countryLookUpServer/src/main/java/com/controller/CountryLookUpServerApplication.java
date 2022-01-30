package com.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com."})
public class CountryLookUpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryLookUpServerApplication.class, args);
	}

}
