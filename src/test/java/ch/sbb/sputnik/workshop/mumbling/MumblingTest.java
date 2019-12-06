/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mumbling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MumblingTest {

  @ParameterizedTest(name = "{index} {0}")
  @MethodSource({"ch.sbb.sputnik.workshop.mumbling.StringGeneratorForTest#stringProvider"})
  void test(String input, String expected) {
    Mumbling systemUnderTest = new Mumbling();
    assertThat(systemUnderTest.accum("ZpglnRxqenU"))
        .isEqualTo("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
  }


}
