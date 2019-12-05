/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.rpg.party.pg;

public class Rogue extends PlayableCharacter {

  public Rogue() {
    super(Role.ROGUE);
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
