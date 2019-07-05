package me.xerosoft.controllers;

import me.xerosoft.controllers.services.PrimeGeneratorService;
import me.xerosoft.entity.PrimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("primes")
public class PrimeGeneratorController {

    @Autowired
    private PrimeGeneratorService primeGeneratorService;

    @GetMapping("records")
    public List<PrimeEntity> retrieveRecords() {
        return primeGeneratorService.retrieveRecords();
    }

    @GetMapping()
    public List<Integer> generatePrimes(
            @RequestParam(defaultValue = "cd") String strategy,
            @RequestParam Integer start,
            @RequestParam Integer end
    ) {
        return primeGeneratorService.generate(strategy, start, end);
    }
}
