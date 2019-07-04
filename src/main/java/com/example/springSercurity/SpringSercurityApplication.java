package com.example.springSercurity;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringSercurityApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringSercurityApplication.class);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.println("THIS IS DEMO SPRING BOOT APPLICATION");
			}
		});
		app.run();
	}
}
