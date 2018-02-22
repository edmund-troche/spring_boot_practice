package org.troche.spring.application.exercise.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logging aspect that method calls in controllers.
 */
@Aspect
@Component
public class ControllerLoggingAspect {
    /** Logger for the ControllerLoggingAspect class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    /**
     * log calls to methods in any of the controllers.
     *
     * @param joinPoint joint point that matched the v1 controllers methods.
     *
     * @return object reference for the value returned by the matched method.
     *
     * @throws Throwable any exception from the matched method.
     */
    @Around("org.troche.spring.application.exercise.aspect.CommonJoinPoints.v1ControllersMethodTracing()")
    public Object aroundControllerMethodAdvice(final ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;

        LOGGER.info("Controller method {} took {} ms", joinPoint.toLongString(), elapsedTime);
        LOGGER.info("Controller method {} arguments: {}",
                joinPoint.toLongString(), Arrays.toString(joinPoint.getArgs()));

        return result;
    }
}
