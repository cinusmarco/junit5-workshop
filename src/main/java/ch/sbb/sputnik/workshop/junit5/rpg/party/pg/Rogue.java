/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.party.pg;

import static ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Role.ROGUE;

public class Rogue extends PlayableCharacter {

  public Rogue() {
    super(ROGUE);
  }

  @Override
  public String attack() {
    return "Backstab";
  }

  @Override
  public String defend() {
    return "Dodge & Roll";
  }
}
