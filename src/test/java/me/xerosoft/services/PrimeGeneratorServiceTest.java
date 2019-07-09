package me.xerosoft.services;

import me.xerosoft.domain.prime.exceptions.PrimeStrategyException;
import me.xerosoft.repositories.PrimeGeneratorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class PrimeGeneratorServiceTest {

    @MockBean
    private PrimeGeneratorRepository primeGeneratorRepository;

    @Autowired
    private PrimeGeneratorService primeGeneratorService;

    @TestConfiguration
    public static class PrimeGeneratorServiceImplTestContextConfiguration {
        @Bean
        public PrimeGeneratorService primeGeneratorService() {
            return new PrimeGeneratorServiceImpl();
        }
    }

    @Test
    public void shouldGeneratePrimes() {
        List<Integer> primes = primeGeneratorService.generate("sv", 1, 10);
        Assert.assertEquals(4, primes.size());
    }

    @Test(expected = PrimeStrategyException.class)
    public void shouldRaisePrimeStrategyException() {
        List<Integer> primes = primeGeneratorService.generate("cs", 1, 10);
    }
}
