package com.luv2code.springdemo.step95;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
public class RunConfig {
	@Bean
	public FortuneService suddenFortuneService() {
		return new SuddenFortuneService();
	}

	@Bean
	public Coach runCoach() {
		return new RunCoach(suddenFortuneService());
	}
}
