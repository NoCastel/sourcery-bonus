package com.nocastel.task;
// You got a task to create an internal tool to keep all employee's data of your company. Currently, the list of employees is exported to a CSV file.

// As a first story, your target is to allow the HR team to upload this data from a file and display it in the web app.
// Use Spring Boot, H2, and React.

// Provide git repository with implementation and instructions on how to run the app.This question is required. 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
