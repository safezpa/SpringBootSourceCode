package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect //1 ����һ������
@Component //2 �ô������Ϊspring���������Bean
public class LogAspect {
	
	@Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)") //3 ͨ��@PointCut�����е�
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") //4 ͨ��@Afterע������һ��Advice��ʹ��@Pointcut������е�
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("ע��ʽ���� " + action.name()); //5 ͨ��������Ի��ע���ϵ�����
	    }
	  
	   @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
	   // ֱ��ʹ�����ع�����Ϊ����
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("��������ʽ����,"+method.getName());

	    }
	   
	  
	
}
