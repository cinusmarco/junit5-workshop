/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.rpg.party.pg;

public class Mage extends PlayableCharacter {

  public Mage() {
    super(Role.MAGE);
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
