/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife;

import ch.sbb.sputnik.workshop.tdd.gameoflife.impl.BoardFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BoardTest {

  @Test
  void aBoard_withDeadCells_remains_aBoardWithDeadCells() {

    Board board0 =
        BoardFactory.generateInitialBoard(
            new String[][] {{"0", "0", "0", "0"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}});

    Board board1 = board0.step();

    assertThat(board1.representation()).isEqualTo(board0.representation());
  }

  @Test
  void aBoard_withABlock_remains_aBoardWithaBlock() {

    Board board0 =
        BoardFactory.generateInitialBoard(
            new String[][] {{"0", "0", "0", "0"}, {"0", "1", "1", "0"}, {"0", "1", "1", "0"}, {"0", "0", "0", "0"}});

    Board board1 = board0.step();

    String[][] state =
        new String[][] {
          {"0", "0", "0", "0"},
          {"0", "1", "1", "0"},
          {"0", "1", "1", "0"},
          {"0", "0", "0", "0"}
        };

    assertThat(board0.representation()).isEqualTo(state);
    assertThat(board1.representation()).isEqualTo(state);
  }

  @Test
  void aBoard_withABlinker_hasExactlyTwoStates() {

    String[][] state0 =
        new String[][] {
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "1", "1", "1", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"}
        };
    String[][] state1 =
        new String[][] {
          {"0", "0", "0", "0", "0"},
          {"0", "0", "1", "0", "0"},
          {"0", "0", "1", "0", "0"},
          {"0", "0", "1", "0", "0"},
          {"0", "0", "0", "0", "0"}
        };

    Board board0 =
        BoardFactory.generateInitialBoard(
            new String[][] {
              {"0", "0", "0", "0", "0"},
              {"0", "0", "0", "0", "0"},
              {"0", "1", "1", "1", "0"},
              {"0", "0", "0", "0", "0"},
              {"0", "0", "0", "0", "0"}
            });

    assertThat(board0.representation()).isEqualTo(state0);

    Board board1 = board0.step();
    assertThat(board1.representation()).isEqualTo(state1);

    Board board2 = board1.step();
    assertThat(board2.representation()).isEqualTo(state0);

    Board board3 = board2.step();
    assertThat(board3.representation()).isEqualTo(state1);
  }

  @Test
  void a5x5Board_ofDeadCell_isA5x5Matrix_fullOfZeros() {

    Board board0 =
        BoardFactory.generateInitialBoard(
            new String[][] {
              {"0", "0", "0", "0", "0"},
              {"0", "0", "0", "0", "0"},
              {"0", "0", "0", "0", "0"},
              {"0", "0", "0", "0", "0"},
              {"0", "0", "0", "0", "0"}
            });

    String[][] expectedRepresentation =
        new String[][] {
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"},
          {"0", "0", "0", "0", "0"}
        };

    assertThat(board0.representation()).isEqualTo(expectedRepresentation);
  }

  @Test
  void a3x4Board_ofDeadCell_isA3x4Matrix_fullOfZeros() {

    Board board0 =
        BoardFactory.generateInitialBoard(
            new String[][] {
              {"0", "0", "0", "0"},
              {"0", "0", "0", "0"},
              {"0", "0", "0", "0"}
            });

    String[][] expectedRepresentation =
        new String[][] {
          {"0", "0", "0", "0"},
          {"0", "0", "0", "0"},
          {"0", "0", "0", "0"}
        };

    assertThat(board0.representation()).isEqualTo(expectedRepresentation);
  }

  @Test
  void a3x4Board_ofLiveCell_isA3x4Matrix_fullOfOnes() {
    Board board0 =
        BoardFactory.generateInitialBoard(
            new String[][] {
              {"1", "1", "1", "1"},
              {"1", "1", "1", "1"},
              {"1", "1", "1", "1"}
            });

    String[][] expectedRepresentation =
        new String[][] {
          {"1", "1", "1", "1"},
          {"1", "1", "1", "1"},
          {"1", "1", "1", "1"}
        };

    assertThat(board0.representation()).isEqualTo(expectedRepresentation);
  }
}
