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

	// Aspect = ����Ʈ��(=�ٽɰ���) + �����̽�(=Ⱦ�ܰ���)
	@Pointcut("execution(* com.spring.study..*ServiceImpl.*(..))")
	public void allPointcut(){}
	
	//@Before("allPointcut()") // �����̽�
	@Before("execution(* com.spring.study..*ServiceImpl.*(..))")
	public void beforPrintLog(JoinPoint jp){
		System.out.println("[AOP �α�] befor : ����Ͻ� ���� ���� �� ���� - " + jp.getSignature().getName());
	}
	
	@After("allPointcut()")
	public void afterPrintLog(JoinPoint jp){
		System.out.println("[AOP �α�] after : ����Ͻ� ���� ���� �� ���� - " + jp.getSignature().getName());
	}
	
	@AfterReturning("allPointcut()")
	public void afterReturningPrintLog(){
		System.out.println("[AOP �α�] after-returning : ����Ͻ� ����");
	}
	
	@Around("allPointcut()")
	public Object arroundPrintLog(ProceedingJoinPoint pjp){
		System.out.println("[AOP �α�] arround : ����Ͻ� ����");
		
		
		Object returnObj = null;
		try {
			returnObj = pjp.proceed();
			
			if (returnObj instanceof UserVO) {
				UserVO vo = (UserVO) returnObj;
				System.out.println("[AOP �α�] arround vo : " + vo.toString());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[AOP �α�] arround : ����Ͻ� ����");
		
		return returnObj;
	}
	
	/*@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void afterThrowingPrintLog(JoinPoint jp, Exception exception){
		System.out.println("[AOP �α�] after-throwing : ����Ͻ� ����");
	}*/
}
