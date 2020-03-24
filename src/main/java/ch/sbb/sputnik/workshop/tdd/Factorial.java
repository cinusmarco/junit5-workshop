/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd;

import java.util.ArrayList;
import java.util.List;

public class Factorial {
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
