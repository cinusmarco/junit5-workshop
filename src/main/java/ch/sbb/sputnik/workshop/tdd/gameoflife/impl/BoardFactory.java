/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife.impl;

import ch.sbb.sputnik.workshop.tdd.gameoflife.Board;

import java.util.Arrays;

public class BoardFactory {
  private BoardFactory() {}

  public static Board generateInitialBoard(String[][] seed) {
    final Cell[][] cells =
        Arrays.stream(seed)
            .map(
                row ->
                    Arrays.stream(row)
                        .map(s -> "1".equals(s) ? Cell.aliveCell() : Cell.deadCell())
                        .toArray(Cell[]::new))
            .toArray(Cell[][]::new);
    return new BoardImpl(cells);
  }
}
