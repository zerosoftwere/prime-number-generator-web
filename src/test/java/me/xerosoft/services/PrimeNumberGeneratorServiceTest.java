package me.xerosoft.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PrimeNumberGeneratorServiceTest {
    @Autowired
    private PrimeGeneratorService primeGeneratorService;


    public void retrievesPrimeNumbers() {
        List<Integer> primes = primeGeneratorService.generate("cd",10, 20);
        Assert.assertEquals(primes.size(), 4);
    }
}
