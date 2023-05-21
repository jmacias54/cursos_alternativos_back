package com.mx.alternativecourses.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {
	"com.mx.alternativecourses.api.application.beans",
	"com.mx.alternativecourses.api.application.configuration",
	"com.mx.alternativecourses.api.application.controller"
})

public class AlternativeCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlternativeCoursesApplication.class, args);
	}

}