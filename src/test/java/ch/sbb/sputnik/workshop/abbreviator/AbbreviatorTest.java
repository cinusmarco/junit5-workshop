/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.abbreviator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbbreviatorTest {
    private Abbreviator abbr;

    @BeforeEach
    public void setup() {
        abbr = new Abbreviator();
    }

    @Test
    public void test1() {
        assertThat(abbr.abbreviate("internationalization")).isEqualTo("i18n");
    }

    @Test
    public void test2() {
        assertThat(abbr.abbreviate("elephant-rides are really fun!")).isEqualTo("e6t-r3s are r4y fun!");
    }
}
