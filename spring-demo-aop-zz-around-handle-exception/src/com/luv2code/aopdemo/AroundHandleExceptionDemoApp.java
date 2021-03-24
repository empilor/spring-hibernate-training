package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    
    public static void main(String... args) throws InterruptedException {

        // read the Spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the account bin from the container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");

        logger.info("Calling getFortune");

        boolean tripWire = true;
        String data = fortuneService.getFortune(tripWire);

        logger.info("\nMy fortune is: " + data);

        logger.info("Finished");

        // close the context
        context.close();
    }

}
