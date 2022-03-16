package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;


@SpringBootApplication
public class Bot2Application {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(Bot2Application.class, args);
	}

}
