package com.company.aspect;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiLoggingAspect {
	
	private static final Logger LOG = Logger.getLogger(ApiLoggingAspect.class);
	
	@Pointcut("execution (* com.company.controller.api.*.*(..))")
	private void executionOfAPIMethod(){}
	
	@Before("executionOfAPIMethod()")
	public void beforeEnteringControllerAPI(JoinPoint joinPoint){
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		
		LOG.info("Before execution of " + signature + " ,time = " + LocalDateTime.now());
		
		if(joinPoint.getArgs() != null || joinPoint.getArgs().length != 0){
			LOG.info("Input arguments : ");
			
			for(Object arg : joinPoint.getArgs()){
				LOG.info("Argument:\t" + arg);
			}
			
		}
		
	}
	
	@AfterReturning(
			pointcut = "executionOfAPIMethod()",
			returning = "result"
			)
	public void afterReturningFromApiController(JoinPoint joinPoint,Object result){
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		LOG.info("Method : " + signature + " has suceeded");
	}

	@AfterThrowing(
			pointcut = "executionOfAPIMethod()",
			throwing = "exc"
			)
	public void afterThrowingFromApiController(JoinPoint joinPoint, Throwable exc){
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exc.printStackTrace(pw);

		LOG.info("Method : " + signature + " has failed");
		LOG.info("Exception : " + exc.getClass());
		LOG.info("Stack trace : " + sw.toString());
	}
	
	@After("executionOfAPIMethod()")
	public void afterFinallyFromApiController(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		LOG.info("End of method : " + signature + " execution , time = " + LocalDateTime.now());
	}
	
	@Around("executionOfAPIMethod()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		
		long start = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		LOG.info("Execution time of " + method +  " in ms : " + (end - start));
		
		return result;
	}
}
