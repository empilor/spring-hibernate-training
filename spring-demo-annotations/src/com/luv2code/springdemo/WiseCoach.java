package com.luv2code.springdemo;

import static com.luv2code.springdemo.LoggerHelper.buildLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WiseCoach implements Coach {

	@Autowired
	@Qualifier("sayingFortuneService")
	private FortuneService fortuneService;

	@Value("${edu.email}")
	private String email;
	@Value("${edu.team}")
	private String team;
	@Value("${edu.refresh}")
	private String refreshPolicy;

	public WiseCoach() {
		System.out.println(buildMessage("inside the no-args default constructor"));
	}

	@Override
	public String getDailyWorkout() {
		return buildMessage("Practice wisdom for 10 minutes. Become wiser!");
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
	    builder.append("WiseCoach [fortuneService=").append(fortuneService).append(", email=").append(email)
		    .append(", team=").append(team).append(", refreshPolicy=").append(refreshPolicy).append("]");
	    return builder.toString();
	}

}
