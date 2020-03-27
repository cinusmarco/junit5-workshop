/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife;

public interface Board {


    Board step();

    String[][] representation();
}
