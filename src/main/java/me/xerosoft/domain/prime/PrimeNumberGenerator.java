package me.xerosoft.domain.prime;

import java.util.List;

public interface PrimeNumberGenerator {
    /**
     * Generate a list of prime number with the given range
     * @param start starting index
     * @param end ending index
     * @return list of prime numbers
     * @throws IndexOutOfBoundsException range should be with (1 and MAX_INTEGER)
     */
    List<Integer> generate(int start, int end) throws IndexOutOfBoundsException;

    /** The name of the generator algorithm
     * @return the name of the generator
     */
    String getStrategyName();
}
