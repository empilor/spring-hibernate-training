package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RefreshCoach implements Coach{
    
    private FortuneService fortuneService;

    @Autowired
    public RefreshCoach(@Qualifier("sayingFortuneService") FortuneService fortuneService) {
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	// TODO Auto-generated method stub
	return "Refresh knowledge every 2 weeks is the best practice";
    }

    @Override
    public String getDailyFortune() {
	// TODO Auto-generated method stub
	return fortuneService.getFortune();
    }
    
    
}
