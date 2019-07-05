package me.xerosoft.domain.prime.factory;

import me.xerosoft.domain.prime.*;
import me.xerosoft.domain.prime.exceptions.PrimeStrategyException;

public class PrimeNumberGeneratorFactory {
    /**
     * Retrieves an instance of prime number generator strategy
     * @param strategy the algorithm use in generating the prime numbers
     * @return
     * @throws PrimeStrategyException strategy specified could not be found
     */
    public PrimeNumberGenerator getByStrategy(String strategy) throws PrimeStrategyException {
        switch (strategy) {
            case "td":
            case "test-divide":
                return new TestDividePrimeNumberGenerator();
            case "sv":
            case "sieve":
                return new SievePrimeNumberGenerator();
            case "sd":
            case "sieve-divide":
                return new SieveDividePrimeNumberGenerator();
            case "cd":
            case "concurrent-divide":
                return new ConcurrentTestDividePrimeNumberGenerator();
        }
        throw new PrimeStrategyException("Strategy not found");
    }
}
