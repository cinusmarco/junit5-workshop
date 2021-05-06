/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd;

import ch.sbb.sputnik.workshop.tdd.factorial.Factorial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FactorialTest {

  @ParameterizedTest
  @MethodSource(value = "provider")
  void testFactorial(int n, List<Integer> expected) {
    Factorial sut = new Factorial();
    assertThat(sut.factors(n)).isEqualTo(expected);
  }

  private static Stream<Arguments> provider() {
    return Stream.of(
        Arguments.of(1, Collections.emptyList()),
        Arguments.of(2, Collections.singletonList(2)),
        Arguments.of(3, Collections.singletonList(3)),
        Arguments.of(4, Stream.of(2, 2).collect(Collectors.toList())),
        Arguments.of(5, Stream.of(5).collect(Collectors.toList())),
        Arguments.of(6, Stream.of(2, 3).collect(Collectors.toList())),
        Arguments.of(7, Stream.of(7).collect(Collectors.toList())),
        Arguments.of(8, Stream.of(2, 2, 2).collect(Collectors.toList())),
        Arguments.of(9, Stream.of(3, 3).collect(Collectors.toList())),
        Arguments.of(2*2*2*3*5*7*11*13, Stream.of(2,2,2,3,5,7,11,13).collect(Collectors.toList()))
        );
  }
}
