/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd;

import java.util.ArrayList;
import java.util.List;

public class Factorial2 {
  public List<Integer> factors(int n) {
    List<Integer> fattoriPrimi = new ArrayList<>();
    int fattore = 2;
    int resto = n;
    while (resto > 1) {
      while (resto % fattore == 0) {
        fattoriPrimi.add(fattore);
        resto /= fattore;
      }
      fattore++;
    }

    return fattoriPrimi;
  }
}
