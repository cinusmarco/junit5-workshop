/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.gildedrose;

class ItemWrapperFactory {

  private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
  private static final String AGED_BRIE = "Aged Brie";
  private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

  static ItemWrapper wrap(Item item) {
    switch (item.name) {
      case SULFURAS_HAND_OF_RAGNAROS:
        return new ItemWrapper.SulfurasItemWrapper(item);
      case AGED_BRIE:
        return new ItemWrapper.AgedBrieItemWrapper(item);
      case BACKSTAGE_PASS:
        return new ItemWrapper.BackstagePassItemWrapper(item);
      case CONJURED_MANA_CAKE:
        return new ItemWrapper.ConjeredItemWrapper(item);
      default:
        return new ItemWrapper.GenericItemWrapper(item);
    }
  }

  private ItemWrapperFactory() {
    throw new UnsupportedOperationException("You shall not call me!");
  }
}
