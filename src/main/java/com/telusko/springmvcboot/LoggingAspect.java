package com.telusko.springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@After("execution(public * com.telusko.springmvcboot.AlienController.getAliens())")
	public void log() {
		System.out.println("getAlien method called here....");
	}

}
