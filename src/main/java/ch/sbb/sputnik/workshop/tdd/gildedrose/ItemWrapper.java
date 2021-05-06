/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.gildedrose;

abstract class ItemWrapper {

  private final Item item;

  ItemWrapper(Item item) {
    this.item = item;
  }

  int getSellIn() {
    return item.sellIn;
  }

  void setQualityToZero() {
    item.quality = 0;
  }

  void increaseQuality() {
    if (item.quality < 50) item.quality++;
  }

  void decreaseQuality() {
    if (item.quality > 0) item.quality--;
  }

  void decreaseSellIn() {
    item.sellIn--;
  }

  boolean isExpired() {
    return getSellIn() < 0;
  }

  abstract void updateQuality();

  void update() {
    this.updateQuality();
    this.updateExpiration();
  }

  private void updateExpiration() {
    this.decreaseSellIn();
    if (this.isExpired()) {
      updateQuality();
    }
  }

  @Override
  public String toString() {
    return item.toString();
  }

  static class GenericItemWrapper extends ItemWrapper {
    GenericItemWrapper(Item item) {
      super(item);
    }

    @Override
    void updateQuality() {
      decreaseQuality();
    }
  }

  static class SulfurasItemWrapper extends ItemWrapper {
    SulfurasItemWrapper(Item item) {
      super(item);
    }

    @Override
    void decreaseSellIn() {
      // Sulfuras never expires
    }

    @Override
    void decreaseQuality() {
      // Sulfuras quality never alters
    }

    @Override
    void updateQuality() {
      // Sulfuras quality never alters
    }
  }

  static class AgedBrieItemWrapper extends ItemWrapper {
    AgedBrieItemWrapper(Item item) {
      super(item);
    }

    @Override
    void updateQuality() {
      increaseQuality();
    }

    @Override
    void decreaseQuality() {
      // Aged brie never decrease in quality
    }
  }

  static class BackstagePassItemWrapper extends ItemWrapper {
    BackstagePassItemWrapper(Item item) {
      super(item);
    }

    @Override
    void updateQuality() {
      increaseQuality();
      if (this.getSellIn() < 11) {
        this.increaseQuality();
      }

      if (this.getSellIn() < 6) {
        this.increaseQuality();
      }

      if (isExpired()) {
        setQualityToZero();
      }
    }
  }

  static class ConjeredItemWrapper extends ItemWrapper {
    ConjeredItemWrapper(Item item) {
      super(item);
    }

    @Override
    void updateQuality() {
      decreaseQuality();
      decreaseQuality();
    }
  }
}
