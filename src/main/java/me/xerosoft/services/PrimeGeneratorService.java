package me.xerosoft.services;

import me.xerosoft.entity.PrimeEntity;

import java.util.List;

public interface PrimeGeneratorService {

    List<Integer> generate(String strategy, int start, int end);
    List<PrimeEntity> retrieveRecords();
}
