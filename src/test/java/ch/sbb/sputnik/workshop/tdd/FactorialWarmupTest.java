/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd;

import ch.sbb.sputnik.workshop.tdd.factorial.FactorialWarmup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FactorialWarmupTest {

  @ParameterizedTest
  @MethodSource(value = "provider")
  void testFatcorial(int n, List<Integer> expectedFactors) {
    FactorialWarmup sut = new FactorialWarmup();
    assertThat(sut.factors(n)).isEqualTo(expectedFactors);
  }

  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of(1, Collections.emptyList()),
        Arguments.of(2, Stream.of(2).collect(Collectors.toList())),
        Arguments.of(3, Stream.of(3).collect(Collectors.toList())),
        Arguments.of(4, Stream.of(2, 2).collect(Collectors.toList())),
        Arguments.of(5, Stream.of(5).collect(Collectors.toList())),
        Arguments.of(6, Stream.of(2,3).collect(Collectors.toList())),
        Arguments.of(7, Stream.of(7).collect(Collectors.toList())),
        Arguments.of(8, Stream.of(2,2,2).collect(Collectors.toList())),
        Arguments.of(9, Stream.of(3,3).collect(Collectors.toList()))
        );
  }
}
