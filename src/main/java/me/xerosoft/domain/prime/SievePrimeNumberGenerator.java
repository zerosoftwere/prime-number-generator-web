package me.xerosoft.domain.prime;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class SievePrimeNumberGenerator implements PrimeNumberGenerator{
    private static final String STRATEGY = "Sieve";

    public List<Integer> generate(int start, int end) throws IndexOutOfBoundsException {
        if (start < 0) throw new IndexOutOfBoundsException();

        BitSet primeBits = new BitSet();

        // a <= sqrt(n) and b <= sqrt(n) then ab <= n
        int stop = (int) Math.sqrt(end);

        // for all numbers that has not been visited
        // go ahead and set the bits of all its multiples
        for(int i = 2; i <= stop; i++) {
            if (!primeBits.get(i)) {
                for (int j = i * i; j < end; j = j + i) {
                    primeBits.set(j);
                }
            }
        }

        // since non prime bits was set, flip all bit to obtain
        // primes
        primeBits.flip(2, end);

        // select primes from specified start
        return primeBits.stream()
                    .filter(i -> i >= start).boxed()
                    .collect(Collectors.toList());
    }

    @Override
    public String getStrategyName() {
        return this.STRATEGY;
    }
}
