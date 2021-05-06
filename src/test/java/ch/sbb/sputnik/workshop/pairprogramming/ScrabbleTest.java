/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.pairprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScrabbleTest {

  private static Stream<Arguments> dataProvider() {
    return Stream.of(Arguments.of("HEY", 4 + 1 + 4), Arguments.of("PIPPO", 3 + 1 + 3 + 3 + 1));
  }

  @ParameterizedTest
  @MethodSource(value = "dataProvider")
  void test(String input, int expected) {
    // Arrange
    ScrabblePointComputer systemUnderTest = new ScrabblePointComputer();
    // Act
    int result = systemUnderTest.computeResult(input);
    // Assert
    assertThat(result).isEqualTo(expected);
  }
}
