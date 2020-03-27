/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife;

import ch.sbb.sputnik.workshop.tdd.gameoflife.impl.BoardFactory;

public class GameOfLife {
  public static void main(String[] args) throws InterruptedException {

    String[][] seed =
        new String[][] {
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "1", "1", "1", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"}
        };

    clearScreen();
    Board board = BoardFactory.generateInitialBoard(seed);
    print(board.representation());
    for (int i = 0; i < 25; i++) {
      clearScreen();
      print(board.representation());
      Thread.sleep(1000);
      board = board.step();
    }
  }

  private static void clearScreen() {

    for (int i = 0; i < 10; i++) {
      System.out.println();
    }
  }

  private static void print(String[][] representation) {
    for (String[] strings : representation) {
      for (String string : strings) {
        System.out.printf("%4s", string);
      }
      System.out.println();
    }
  }
}
