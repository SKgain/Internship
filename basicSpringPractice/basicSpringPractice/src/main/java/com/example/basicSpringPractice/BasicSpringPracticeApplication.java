package com.example.basicSpringPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicSpringPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringPracticeApplication.class, args);
	}

}
