package com.springAOP;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@After("execution(* com.springAOP.ReportService.generateReport(..))")  
	public void logAfterAdvice(JoinPoint joinPoint) {
		System.out.println("In Advice, Joinpoint signature :" + joinPoint.getSignature());
		long time = System.currentTimeMillis();
		
		System.out.println("Report generated at time:" + DateFormat.getDateTimeInstance().format(time));
		
	}

}
