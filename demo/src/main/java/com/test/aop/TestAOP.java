package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class TestAOP {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	@After(value = "execution(* com.example.demo.*.*(..))")
	public void test2(JoinPoint jp) {
		logger.info("Entered into after:"+jp.getTarget().getClass().getCanonicalName());
		
	}
	
	@AfterReturning(value = "execution(* com.example.demo.*.*(..))")
	public void test3(JoinPoint jp) {
		logger.info("Entered into return :"+jp.getTarget().getClass().getCanonicalName());
		
	}
	
	@AfterThrowing(value = "execution(* com.example.demo.*.*(..))",throwing = "ex")
	public void test4(JoinPoint jp,Throwable ex) {
		try {
			logger.info("Entered into throwing :"+jp.getTarget().getClass().getCanonicalName()+"exception:"+ex.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}
	
	
	
	
}
