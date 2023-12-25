package com.infosys.poolcarz.fare.utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger=null;

    @Around("execution(* com.infosys.poolcarz.fare.service..*(..)) ||"
    +" execution(* com.infosys.poolcarz.fare.repository..*(..))")
    public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable{
        getLog(joinPoint);
        long startTime=System.currentTimeMillis();
        String className=joinPoint.getSignature().getDeclaringTypeName();
        String methodName=joinPoint.getSignature().getName();
        String str= Arrays.toString(joinPoint.getArgs());
        logger.info("{} : Entering into {} with param {}",className,methodName,str );

        Object result=joinPoint.proceed();
        long endTime=System.currentTimeMillis();

        logger.info("{} : Exiting {} with result {} -- execution completed in {} ms", className, methodName,
                result,endTime-startTime);

        return result;
    }

    protected void getLog(JoinPoint jp){
        logger= LoggerFactory.getLogger(jp.getTarget().getClass());

    }


}
