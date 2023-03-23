package com.JatinCodes.learnspringaop.aopexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // this says this annotation will only work for method
@Retention(RetentionPolicy.RUNTIME) // this says this annotation will only work at RunTime
public @interface TrackTime {

}
