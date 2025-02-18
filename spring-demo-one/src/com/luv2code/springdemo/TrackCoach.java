package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do It: " + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Track coach: inside method doMyStartupStuff");
	}

	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("Track coach: inside method doMyCleanupStuffYoYo");
	}
}
