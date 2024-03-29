package com.training.springcore.config;


import com.training.springcore.service.Monitored;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoredAspect {
    @Before("@annotation(com.training.springcore.service.Monitored)")

    public void logServiceBeforeCall(JoinPoint jp) {
        System.out.println("Appel finder " + jp.getSignature());
    }
}
