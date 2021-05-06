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
