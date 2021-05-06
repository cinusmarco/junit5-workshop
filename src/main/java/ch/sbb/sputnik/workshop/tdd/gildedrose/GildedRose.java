/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021.
 */

package ch.sbb.sputnik.workshop.tdd.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

  private final List<ItemWrapper> itemWrappers;

  public GildedRose(Item[] items) {
    itemWrappers = Arrays.stream(items).map(ItemWrapperFactory::wrap).collect(Collectors.toList());
  }

  public void updateQuality() {
    itemWrappers.forEach(ItemWrapper::update);
  }
}
