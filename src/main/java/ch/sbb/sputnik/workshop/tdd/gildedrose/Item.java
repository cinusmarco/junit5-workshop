/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.gildedrose;

public class Item {
  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
