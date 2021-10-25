package com.github.rudysysu.springboot.aspects.aspect;

import com.github.rudysysu.springboot.aspects.annotation.DataSourceChange;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect {
    private static final Logger LOG = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut(value = "@annotation(com.github.rudysysu.springboot.aspects.annotation.DataSourceChange)")
    private void changeDS() {
    }

    @Around(value = "changeDS() ", argNames = "pjp")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        DataSourceChange annotation = method.getAnnotation(DataSourceChange.class);

        LOG.warn("---------- slave: " + annotation.slave() + " ----------");

        return pjp.proceed();
    }
}
