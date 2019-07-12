package me.xerosoft.domain.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PrimeGeneratorAspect {

    @Before("execution(* me.xerosoft.services.PrimeGeneratorService.generate(..))")
    public void verifyPrimeGeneratorInput(JoinPoint jointPoint) {
        int start = (Integer) jointPoint.getArgs()[1];
        int end = (Integer) jointPoint.getArgs()[2];

        if (start < 0 || start > end) {
            String message = String.format("invalid range: %d to %d", start, end);
            throw new IndexOutOfBoundsException(message);
        }
    }
}
