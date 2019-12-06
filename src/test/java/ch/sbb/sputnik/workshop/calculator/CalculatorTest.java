/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

  @Test
  @DisplayName("My 1st JUnit 5 test! :-D")
  void myFirstTest(TestInfo testInfo) {
    Calculator calculator = new Calculator();
    int a = 13;
    int b = 17;
    assertThat(calculator.add(a, b)).as(String.format("%d + %d should be equal to %d", a, b, a + b)).isEqualTo(a + b);

    assertThat(testInfo.getDisplayName()).isEqualTo("My 1st JUnit 5 test! :-D");
  }
}
