/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mumbling;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MumblingTest {

    @Test
    public void test1() {
        Mumbling systemUnderTest = new Mumbling();
        assertThat(systemUnderTest.accum("ZpglnRxqenU"))
                .isEqualTo("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
    }

    @Test
    public void test2() {
        Mumbling systemUnderTest = new Mumbling();
        assertThat(systemUnderTest.accum("NyffsGeyylB"))
                .isEqualTo("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb");
    }

    @Test
    public void test3() {
        Mumbling systemUnderTest = new Mumbling();
        assertThat(systemUnderTest.accum("EvidjUnokmM"))
                .isEqualTo("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm");
    }

    @Test
    public void test4() {
        Mumbling systemUnderTest = new Mumbling();
        assertThat(systemUnderTest.accum("MjtkuBovqrU"))
                .isEqualTo("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu");
    }

    @Test
    public void test5() {
        Mumbling systemUnderTest = new Mumbling();
        assertThat(systemUnderTest.accum("HbideVbxncC"))
                .isEqualTo("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc");
    }
}
