/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.rpg.party.pg;

public class Warrior extends PlayableCharacter {

  public Warrior() {
    super(Role.WARRIOR);
  }

  @Override
  public String attack() {
    return "Smash";
  }

  @Override
  public String defend() {
    return "Shield Block";
  }
}
