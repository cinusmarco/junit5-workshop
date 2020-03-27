/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CellTest {

  @ParameterizedTest
  @MethodSource(value = "livingCellTestCaseProvider")
  void livingCell_stepTest(List<Cell> neighbours, boolean isAlive) {

    Cell livingCell = Cell.aliveCell();
    Cell result = livingCell.step(neighbours);
    assertThat(result.isAlive()).isEqualTo(isAlive);
  }

  @ParameterizedTest
  @MethodSource(value = "deadCellTestCaseProvider")
  void deadCell_stepTest(List<Cell> neighbours, boolean isAlive) {

    Cell livingCell = Cell.deadCell();
    Cell result = livingCell.step(neighbours);
    assertThat(result.isAlive()).isEqualTo(isAlive);
  }

  @Test
  void aCell_isImmutable() {
    Cell livingCell = Cell.aliveCell();

    List<Cell> neighbours =
        Stream.of(
                Cell.aliveCell(),
                Cell.aliveCell(),
                Cell.deadCell(),
                Cell.deadCell(),
                Cell.deadCell(),
                Cell.deadCell(),
                Cell.deadCell(),
                Cell.deadCell())
            .collect(Collectors.toList());

    Cell result = livingCell.step(neighbours);

    assertThat(result).isNotSameAs(livingCell);
  }

  private static Stream<Arguments> livingCellTestCaseProvider() {
    return Stream.of(
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            true),
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.aliveCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.aliveCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            true));
  }

  private static Stream<Arguments> deadCellTestCaseProvider() {
    return Stream.of(
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.aliveCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            false),
        Arguments.of(
            Stream.of(
                    Cell.aliveCell(),
                    Cell.aliveCell(),
                    Cell.aliveCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell(),
                    Cell.deadCell())
                .collect(Collectors.toList()),
            true));
  }
}
