/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.calculator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    /*
    1) I'd like to see that the display name of this test is: "My 1st JUnit 5 test! :-D"
    2) The following assertion is added to the end of the test: assertThat(testInfo.getDisplayName()).isEqualTo("My 1st JUnit 5 test! :-D");

     */
    @Test
    public void test() {
        Calculator calculator = new Calculator();
        int a = 13;
        int b = 17;

        assertThat(calculator.add(a, b)).isEqualTo(a + b);
    }
}
