package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private   Environment env;

    //pointcut 匹配aop下的suoyou
    @Pointcut("within(com.wisely.highlight_spring4.ch1.aop.*)")
    public void loggingPointcut(){
        //方法为空，这只是一个切入点 实现是在advices中

    }

    /**
     * 方法抛出异常拦截
     */
    @AfterThrowing(pointcut = "loggingPointcut()",throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable throwable){
            log.error("Exception in {}.{}() with cause=\'{}\' and exception=\'{}\'",

                    joinPoint.getSignature().getDeclaringType(),
                    joinPoint.getSignature().getName(),
                    throwable.getCause()!=null? throwable.getCause():"NULL",
                    throwable.getMessage(),
                    throwable
                    );
        System.out.println(throwable);
        System.out.println(env.acceptsProfiles("dev"));
        System.out.println(env.getActiveProfiles());
        System.out.println(env.getDefaultProfiles());
    }

    /**
     * 方法进入退出拦截
     *
     */

    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //进入方法
        log.debug("Enter: {}.{}() with arguments[s]={}",
                joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
                );
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        Object result=joinPoint.proceed();
        //退出方法
        log.debug("Exit：{}.{}() with result={}",
                joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(),
                result
                );

        System.out.println(result);
        System.out.println(env.acceptsProfiles("dev"));
        System.out.println(env.getActiveProfiles());
        System.out.println(env.getDefaultProfiles());
        return result;
    }

}
