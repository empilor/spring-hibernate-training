package com.luv2code.springdemo.step95;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.FortuneService;

@Component
public class SuddenFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Suddenly your legs got wings!";
	}

}
