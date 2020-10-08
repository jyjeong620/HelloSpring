package com.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect     //aop를 사용할때 사용하는 애노테이션
@Component
public class TimeTraceAop {

    @Around("execution(* com.hellospring..*(..)) && !target(com.hellospring.SpringConfig)")      //사용할 패치키명 입력 &&를 사용하는 이유 https://www.inflearn.com/questions/48156
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "Ms");
        }

    }
}
