package com.luv2code.springdemo.step95;

import static com.luv2code.springdemo.LoggerHelper.buildLog;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.FortuneService;

@Component
public class RunCoach implements Coach {

	private FortuneService fortuneService;

	public RunCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return buildMessage("Run 3 kilometers as a warm up training");
	}

	@Override
	public String getDailyFortune() {
		return buildMessage(fortuneService.getFortune());
	}

	private String buildMessage(String inputString) {
		return buildLog(this, inputString);
	}
}
