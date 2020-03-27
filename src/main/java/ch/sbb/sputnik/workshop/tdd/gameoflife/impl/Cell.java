/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife.impl;

import java.util.List;

public class Cell {
  private boolean alive;

  private Cell(boolean alive) {
    this.alive = alive;
  }

  static Cell deadCell() {
    return new Cell(false);
  }

  static Cell aliveCell() {
    return new Cell(true);
  }

  Cell step(List<Cell> neighbours) {
    final long aliveNeighbours = neighbours.stream().filter(Cell::isAlive).count();

    return this.alive ? liveCellStep(aliveNeighbours) : deadCellStep(aliveNeighbours);
  }

  private Cell liveCellStep(long aliveNeighbours) {
    if (aliveNeighbours == 2 || aliveNeighbours == 3) {
      return Cell.aliveCell();
    }
    return Cell.deadCell();
  }

  private Cell deadCellStep(long aliveNeighbours) {
    if (aliveNeighbours == 3) {
      return Cell.aliveCell();
    }
    return Cell.deadCell();
  }

  boolean isAlive() {
    return alive;
  }

  @Override
  public String toString() {
    return String.format("%s", alive ? "1" : "0");
  }
}
