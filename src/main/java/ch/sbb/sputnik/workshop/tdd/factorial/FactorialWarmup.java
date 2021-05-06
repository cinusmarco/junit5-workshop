/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.factorial;

import java.util.ArrayList;
import java.util.List;

public class FactorialWarmup {

  public List<Integer> factors(final int n) {
    int remainder = n;
    List<Integer> factors = new ArrayList<>();
    int divider = 2;
    while (remainder > 1) {
      while (remainder % divider == 0) {
        factors.add(divider);
        remainder = remainder / divider;
      }
      divider++;
    }

    return factors;
  }
}
