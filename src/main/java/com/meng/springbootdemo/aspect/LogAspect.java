package com.meng.springbootdemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.meng.springbootdemo.controller.TestAopController.*(..))")
    public void LogAspect(){

    }

    @Before("LogAspect()")
    public void doBefore(JoinPoint joinpoint) {
        System.out.println("doBefore");
    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinpoint) {
        System.out.println("doAfter");
    }

    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinpoint) {
        System.out.println("doAfterReturning");
    }

    @AfterThrowing("LogAspect()")
    public void doAfterThrowing(JoinPoint joinpoint) {
        System.out.println("doAfterThrowing");
    }

    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("deAround");
        return joinPoint.proceed();
    }
}
