package com.JatinCodes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // for Aspect Oriented Programming {AOP}
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    // JoinPoint does not provide execution of method , so we use proceedingJoinPoint
    //@Around("execution(* com.JatinCodes.learnspringaop.aopexample.*.*.*(..))") // checking for a package
    @Around("com.JatinCodes.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()") // checking for @TrackTime Annotation
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Start a timer
        long startTimeMillis = System.currentTimeMillis();

        //Execute the method
        Object returnValue = proceedingJoinPoint.proceed();

        //Stop the timer
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {} ms"
                ,proceedingJoinPoint, executionDuration);

        return returnValue;
    }

}
