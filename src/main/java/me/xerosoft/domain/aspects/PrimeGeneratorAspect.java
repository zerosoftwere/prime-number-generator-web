package me.xerosoft.domain.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Configuration
public class PrimeGeneratorAspect {

    @Around("execution(* me.xerosoft.services.PrimeGeneratorService.generate(..))")
    public Object verifyPrimeGeneratorInput(ProceedingJoinPoint jointPoint) throws Throwable{
        int start = (Integer) jointPoint.getArgs()[1];
        int end = (Integer) jointPoint.getArgs()[2];

        if (start < 0 || start > end) {
            String message = String.format("invalid range: %d to %d", start, end);
            throw new IndexOutOfBoundsException(message);
        }

        Object result = jointPoint.proceed();
        return result;
    }
}
