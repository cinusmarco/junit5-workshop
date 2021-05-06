/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

  @ParameterizedTest
  @MethodSource(value = "testDataProvider")
  void updateQuality(Item[] items, int expectedSellIn, int expectedQuality, int days) {

    GildedRose systemUnderTest = new GildedRose(items);

    IntStream.range(0, days).forEach(i -> systemUnderTest.updateQuality());

    assertThat(items[0].sellIn).isEqualTo(expectedSellIn);
    assertThat(items[0].quality).isEqualTo(expectedQuality);
  }

  @SuppressWarnings("unused")
  private static Stream<Arguments> testDataProvider() {
    return Stream.of(
        Arguments.of(new Item[] {new Item("+5 Dexterity Vest", 10, 20)}, 9, 19, 1),
        Arguments.of(new Item[] {new Item("+5 Dexterity Vest", 10, 0)}, 9, 0, 1),
        Arguments.of(new Item[] {new Item("+5 Dexterity Vest", 0, 20)}, -1, 18, 1),
        Arguments.of(new Item[] {new Item("+5 Dexterity Vest", 0, 20)}, -2, 16, 2),
        Arguments.of(new Item[] {new Item("Aged Brie", 2, 0)}, 1, 1, 1),
        Arguments.of(new Item[] {new Item("Aged Brie", 2, 0)}, 0, 2, 2),
        Arguments.of(new Item[] {new Item("Aged Brie", 2, 0)}, -1, 4, 3),
        Arguments.of(new Item[] {new Item("Aged Brie", 2, 49)}, 0, 50, 2),
        Arguments.of(new Item[] {new Item("Aged Brie", 2, 50)}, 1, 50, 1),
        Arguments.of(new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)}, 0, 80, 1),
        Arguments.of(new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)}, 0, 80, 2),
        Arguments.of(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)}, 14, 21, 1),
        Arguments.of(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)}, 9, 22, 1),
        Arguments.of(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)}, 4, 25, 2),
        Arguments.of(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)}, 4, 23, 1),
        Arguments.of(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)}, -1, 0, 1),
        Arguments.of(new Item[] {new Item("Conjured Mana Cake", 3, 6)}, 2, 4, 1),
        Arguments.of(new Item[] {new Item("Conjured Mana Cake", 0, 6)}, -1, 2, 1));
  }
}
