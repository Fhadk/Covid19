package com.Covid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Covid19.model.ActiveUserData;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);
	}
		
	@Bean
	public ActiveUserData activeUserStore(){
	    return new ActiveUserData();
	}

}
