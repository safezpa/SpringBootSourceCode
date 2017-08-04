package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect //1 声明一个切面
@Component //2 让此切面成为spring容器管理的Bean
public class LogAspect {
	
	@Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)") //3 通过@PointCut定义切点
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") //4 通过@After注解声明一个Advice，使用@Pointcut定义的切点
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("注解式拦截 " + action.name()); //5 通过反射可以获得注解上的属性
	    }
	  
	   @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
	   // 直接使用拦截规则作为参数
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("方法规则式拦截,"+method.getName());

	    }
	   
	  
	
}
