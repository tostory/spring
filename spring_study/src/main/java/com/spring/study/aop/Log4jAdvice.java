package com.spring.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.spring.study.user.vo.UserVO;

@Aspect
@Service("log4jAdvice")
public class Log4jAdvice {

	// Aspect = 포인트컷(=핵심관심) + 어드바이스(=횡단관심)
	@Pointcut("execution(* com.spring.study..*ServiceImpl.*(..))")
	public void allPointcut(){}
	
	//@Before("allPointcut()") // 어드바이스
	@Before("execution(* com.spring.study..*ServiceImpl.*(..))")
	public void beforPrintLog(JoinPoint jp){
		System.out.println("[AOP 로그] befor : 비즈니스 로직 수행 전 동작 - " + jp.getSignature().getName());
	}
	
	@After("allPointcut()")
	public void afterPrintLog(JoinPoint jp){
		System.out.println("[AOP 로그] after : 비즈니스 로직 수행 후 동작 - " + jp.getSignature().getName());
	}
	
	@AfterReturning("allPointcut()")
	public void afterReturningPrintLog(){
		System.out.println("[AOP 로그] after-returning : 비즈니스 로직");
	}
	
	@Around("allPointcut()")
	public Object arroundPrintLog(ProceedingJoinPoint pjp){
		System.out.println("[AOP 로그] arround : 비즈니스 로직");
		
		
		Object returnObj = null;
		try {
			returnObj = pjp.proceed();
			
			if (returnObj instanceof UserVO) {
				UserVO vo = (UserVO) returnObj;
				System.out.println("[AOP 로그] arround vo : " + vo.toString());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[AOP 로그] arround : 비즈니스 로직");
		
		return returnObj;
	}
	
	/*@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void afterThrowingPrintLog(JoinPoint jp, Exception exception){
		System.out.println("[AOP 로그] after-throwing : 비즈니스 로직");
	}*/
}
