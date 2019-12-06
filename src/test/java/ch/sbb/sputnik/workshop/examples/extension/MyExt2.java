/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.examples.extension;


import org.junit.jupiter.api.extension.Extension;

public class MyExt2 implements Extension {

    private int anInt = 42;

    public int getAnInt() {
        return anInt;
    }
}
