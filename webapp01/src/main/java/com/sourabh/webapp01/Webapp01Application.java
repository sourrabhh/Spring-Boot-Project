package com.sourabh.webapp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Webapp01Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(Webapp01Application.class, args);
	}

}
