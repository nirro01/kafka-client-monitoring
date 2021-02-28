package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class customKafkaMetric {

    @Pointcut("execution(* org.apache.kafka.clients.consumer.Consumer.*(..))")
    public void timerPointcut() {}

    @Around("timerPointcut() ")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        /* Aspect logic here */
        System.out.println("before");
        Object proceed = joinPoint.proceed();
        System.out.println("after");
        return proceed;
    }
}
