package me.xerosoft.controllers.services;

import me.xerosoft.controllers.repositories.PrimeGeneratorRepository;
import me.xerosoft.domain.prime.PrimeNumberGenerator;
import me.xerosoft.domain.prime.exceptions.PrimeStrategyException;
import me.xerosoft.domain.prime.factory.PrimeNumberGeneratorFactory;
import me.xerosoft.entity.PrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PrimeGeneratorService {
    private static final PrimeNumberGeneratorFactory factory = new PrimeNumberGeneratorFactory();

    @Autowired
    private PrimeGeneratorRepository repository;

    public List<Integer> generate(String strategy, int start, int end) throws PrimeStrategyException {
        PrimeNumberGenerator generator = factory.getByStrategy(strategy);

        Long startTime = System.currentTimeMillis();
        List<Integer> primes = generator.generate(start, end);
        Long stopTime = System.currentTimeMillis();

        int  primeLength = primes.size();
        double timeElapsed = (stopTime - startTime) / 1000.0; // elapsed time in seconds
        String algorithm = generator.getStrategyName();

        PrimeEntity entity = new PrimeEntity(start, end, primeLength, timeElapsed, algorithm);
        repository.save(entity);

        return primes;
    }

    public List<PrimeEntity> retrieveRecords() {
        return repository.findAll();
    }
}
