package org.troche.spring.application.exercise.aspect;

import org.aspectj.lang.annotation.Pointcut;

/** Common join points used by the aspects. */
public class CommonJoinPoints {

    /** Pointcut definition for all methods in V1 controllers. */
    @Pointcut("execution(* org.troche.spring.application.exercise.controller.v1.*.*(..))")
    public void v1ControllersMethodTracing() {}
}
