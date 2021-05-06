/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2020.
 */

package ch.sbb.sputnik.workshop.tdd.gameoflife.impl;

import ch.sbb.sputnik.workshop.tdd.gameoflife.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

public class BoardImpl implements Board {

  private final BoardTile[][] boardTiles;

  BoardImpl(Cell[][] cells) {

    this.boardTiles = wrap(cells);
  }

  private BoardTile[][] wrap(Cell[][] cells) {
    BoardTile[][] wrapped = new BoardTile[cells.length][];

    for (int i = 0; i < cells.length; i++) {
      final Cell[] row = cells[i];
      BoardTile[] boardTileRow = new BoardTile[row.length];
      for (int j = 0; j < row.length; j++) {
        final Cell cell = row[j];
        BoardTile tile = new BoardTile(cell, i, j);
        boardTileRow[j] = tile;
      }
      wrapped[i] = boardTileRow;
    }
    return wrapped;
  }

  @Override
  public Board step() {
    final Cell[][] newCells =
        iterate(boardTile -> boardTile.getCell().step(this.getNeighbours(boardTile)), Cell[]::new, Cell[][]::new);
    return new BoardImpl(newCells);
  }

  @Override
  public String[][] representation() {
    return iterate(boardTile -> boardTile.getCell().toString(), String[]::new, String[][]::new);
  }

  private <T> T[][] iterate(
      Function<BoardTile, T> mapper, IntFunction<T[]> internalGenerator, IntFunction<T[][]> externalGenerator) {
    return Arrays.stream(boardTiles)
        .map(row -> Arrays.stream(row).map(mapper).toArray(internalGenerator))
        .toArray(externalGenerator);
  }

  private List<Cell> getNeighbours(BoardTile boardTile) {
    final int x = boardTile.getX();
    final int y = boardTile.getY();

    List<Cell> neighbours = new ArrayList<>();

    // Cell order to construct the list
    // 1 2 3
    // 4 C 5
    // 6 7 8

    for (int dX = -1; dX < 2; dX++) {
      for (int dY = -1; dY < 2; dY++) {
        if (dX != 0 || dY != 0) {
          Cell cell = getNeighbour(x, y, dX, dY);
          neighbours.add(cell);
        }
      }
    }
    return neighbours;
  }

  private Cell getNeighbour(int x, int y, int dX, int dY) {
    int xCoord = x + dX;
    int yCoord = y + dY;
    return (xCoord < 0 || yCoord < 0 || xCoord >= boardTiles.length || yCoord >= boardTiles[0].length)
        ? Cell.deadCell()
        : boardTiles[xCoord][yCoord].getCell();
  }

  private static class BoardTile {
    private final Cell cell;
    private final int x;
    private final int y;

    BoardTile(Cell cell, int x, int y) {
      this.cell = cell;
      this.x = x;
      this.y = y;
    }

    private Cell getCell() {
      return cell;
    }

    private int getX() {
      return x;
    }

    private int getY() {
      return y;
    }
  }
}
