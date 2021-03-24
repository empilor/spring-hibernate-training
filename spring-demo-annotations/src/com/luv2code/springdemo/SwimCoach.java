package com.luv2code.springdemo;

import static com.luv2code.springdemo.LoggerHelper.buildLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

	@Autowired
	@Qualifier("sadFortuneService")
	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;

	public SwimCoach() {
		System.out.println(buildMessage("inside the no-args default constructor"));
	}

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return buildMessage("Swim 1000 meter as a warm up");
	}

	@Override
	public String getDailyFortune() {
		return buildMessage(fortuneService.getFortune());
	}

	private String buildMessage(String inputString) {
		return buildLog(this, inputString);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SwimCoach [fortuneService=");
		builder.append(fortuneService.getClass().getSimpleName());
		builder.append(", email=");
		builder.append(email);
		builder.append(", team=");
		builder.append(team);
		builder.append("]");
		return builder.toString();
	}

//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println("inside the doSomeCrazyStuff method");
//		this.fortuneService = fortuneService;
//	}

}
