/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.party.pg;

import static ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Role.MAGE;

public class Mage extends PlayableCharacter {

  public Mage() {
    super(MAGE);
  }

  @Override
  public String attack() {
    return "Fireball";
  }

  @Override
  public String defend() {
    return "Magic Shield";
  }
}
