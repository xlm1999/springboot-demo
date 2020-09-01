package com.meng.springbootdemo.aspect;

import com.meng.springbootdemo.annotation.DoneTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Date;

@Aspect
@Component
public class DoneTimeAspect {
    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        System.out.println("方法的开始时间是：" + new Date());
        Object o = joinPoint.proceed();
        System.out.println("方法的结束时间是：" + new Date());
        return o;
    }
}
