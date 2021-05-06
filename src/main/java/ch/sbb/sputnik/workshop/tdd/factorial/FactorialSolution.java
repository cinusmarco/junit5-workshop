/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.factorial;

import java.util.ArrayList;
import java.util.List;

public class FactorialSolution {
  public List<Integer> factorsOf(int n) {
    int remainder = n;
    int divisor = 2;
    List<Integer> factors = new ArrayList<>();
    while (remainder > 1) {
      while (remainder % divisor == 0) {
        factors.add(divisor);
        remainder /= divisor;
      }
      divisor++;
    }
    return factors;
  }
}
