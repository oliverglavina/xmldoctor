package com.oliverglavina.testmarand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
}

//DoctorController handles POST requests to /doctors and adds new doctor entries