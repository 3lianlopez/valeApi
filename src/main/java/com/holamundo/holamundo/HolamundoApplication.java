package com.holamundo.holamundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.holamundo.holamundo")
public class HolamundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolamundoApplication.class, args);
	}
}
