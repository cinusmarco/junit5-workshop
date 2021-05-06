/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.pairprogramming;

import java.util.HashMap;
import java.util.Map;

class ScrabblePointComputer {

  private static final Map<Character, Integer> Tiles =
      new HashMap<Character, Integer>() {
        {
          put('s', 4);
        }
      };

  static {
    Tiles.put(' ', 0);
    Tiles.put('A', 1);
    Tiles.put('B', 3);
    Tiles.put('C', 3);
    Tiles.put('D', 2);
    Tiles.put('E', 1);
    Tiles.put('F', 4);
    Tiles.put('G', 2);
    Tiles.put('H', 4);
    Tiles.put('I', 1);
    Tiles.put('J', 8);
    Tiles.put('K', 5);
    Tiles.put('L', 1);
    Tiles.put('M', 3);
    Tiles.put('N', 1);
    Tiles.put('O', 1);
    Tiles.put('P', 3);
    Tiles.put('Q', 10);
    Tiles.put('R', 1);
    Tiles.put('S', 1);
    Tiles.put('T', 1);
    Tiles.put('U', 1);
    Tiles.put('V', 4);
    Tiles.put('W', 4);
    Tiles.put('X', 8);
    Tiles.put('Y', 4);
    Tiles.put('Z', 10);
  }

  int computeResult(String input) {
    return input.chars().mapToObj(key -> Tiles.get((char) key)).reduce(Integer::sum).orElse(-1);
  }
}
