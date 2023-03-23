package com.JatinCodes.learnspringaop.aopexample.aspects;

/**
 * This file is created to store address and pass it to other files
 * it is made so that we only change here , and other files are not affected
 *
 */

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.JatinCodes.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}


    @Pointcut("execution(* com.JatinCodes.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.JatinCodes.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    // @service ia a Bean , so to execute the particular bean we can do the below thing
    @Pointcut("bean(*Service*)")  // any bean which contain service will be executed
    public void allPackageConfigUsingBean() {}

    // this is made to work for a particular annotation , made by a developer
    @Pointcut("@annotation(com.JatinCodes.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
