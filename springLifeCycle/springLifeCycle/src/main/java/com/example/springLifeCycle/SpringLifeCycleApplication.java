package com.example.springLifeCycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLifeCycleApplication implements CommandLineRunner {

	@Autowired
	public Mobile mobile;

	public static void main(String[] args) {
		SpringApplication.run(SpringLifeCycleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mobile.fun();
	}

}
