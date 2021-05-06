/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Factorial2Test {

  @ParameterizedTest
  @MethodSource(value = "provider")
  void test(int n, List<Integer> expected) {

    Factorial2 systemUnderTest = new Factorial2();

    List<Integer> actual = systemUnderTest.factors(n);

    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of(1, Collections.emptyList()),
        Arguments.of(2, Stream.of(2).collect(Collectors.toList())),
        Arguments.of(3, Stream.of(3).collect(Collectors.toList())),
        Arguments.of(4, Stream.of(2, 2).collect(Collectors.toList())),
        Arguments.of(5, Stream.of(5).collect(Collectors.toList())),
        Arguments.of(6, Stream.of(2, 3).collect(Collectors.toList())),
        Arguments.of(7, Stream.of(7).collect(Collectors.toList())),
        Arguments.of(8, Stream.of(2, 2, 2).collect(Collectors.toList())),
        Arguments.of(9, Stream.of(3, 3).collect(Collectors.toList())),
        Arguments.of(10, Stream.of(2, 5).collect(Collectors.toList())),
        Arguments.of(2*3*5*7*11*13, Stream.of(2,3,5,7,11,13).collect(Collectors.toList()))
        );
  }
}
