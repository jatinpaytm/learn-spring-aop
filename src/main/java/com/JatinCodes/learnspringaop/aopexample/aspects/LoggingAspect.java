package com.JatinCodes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect // for Aspect Oriented Programming {AOP}
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    // we are intercepting all calls going into to aopexample package
    //@Pointcut("execution(* com.JatinCodes.learnspringaop.aopexample.*.*.*(..))")//WHEN  // use @Before instead of @Pointcut
    @Before("com.JatinCodes.learnspringaop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")//WHEN   // to execute a pointcut before a method is called
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        // Logic - What ?
        logger.info("Before Aspect - {} is called with arguments: {}"
                  ,joinPoint, joinPoint.getArgs());//WHAT
    }

    @After("com.JatinCodes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed",  joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.JatinCodes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}"
                ,  joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.JatinCodes.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}"
                ,  joinPoint, resultValue);
    }

}