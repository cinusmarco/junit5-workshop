/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.abbreviator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AbbreviatorTest {

  @ParameterizedTest(name = "{index} [{0}] should shrink to [{1}]")
  @CsvFileSource(resources = "/examples.csv")
  public void test(String input, String expected) {
    System.err.println(input);
    Abbreviator abbr = new Abbreviator();
    assertThat(abbr.abbreviate(input)).isEqualTo(expected);
  }
}
