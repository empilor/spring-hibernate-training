package com.luv2code.springdemo;

import static com.luv2code.springdemo.LoggerHelper.buildLog;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println(buildMessage("inside the no-args default constructor"));
	}

	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
		System.out.println(buildMessage("inside the constructor with arguments"));
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return buildMessage("Practice your backhand valley");
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(buildMessage("inside the doMyStartupStuff method"));
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(buildMessage("inside the doMyCleanupStuff method"));
	}

	private String buildMessage(String inputString) {
		return buildLog(this, inputString);
	}

}
