/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.abbreviator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AbbreviatorTest {
    private Abbreviator abbr;

    @BeforeEach
    public void setup() {
        abbr = new Abbreviator();
    }

    // Skip the first line
    @ParameterizedTest
    @CsvFileSource(resources = "/examples.csv", numLinesToSkip = 1)
    void test_csv_file(String input, String output) {
        assertThat(abbr.abbreviate(input)).isEqualTo(output);
    }
}
