/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.party;

import ch.sbb.sputnik.workshop.junit5.rpg.db.ID;
import ch.sbb.sputnik.workshop.junit5.rpg.db.StupidDB;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Mage;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Rogue;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Role;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Warrior;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Party {

  private final StupidDB stupidDB;

  public Party(StupidDB stupidDB) {
    this.stupidDB = stupidDB;
  }

  void setPartyOnlyForTests(ArrayList<PlayableCharacter> playableCharacters) {
    stupidDB.setPlayableCharacters(playableCharacters);
  }

  public ID hire(String name, double pay, Role role) {
    PlayableCharacter pg = null;
    switch (role) {
      case MAGE:
        pg = new Mage();
        break;
      case ROGUE:
        pg = new Rogue();
        break;
      case WARRIOR:
        pg = new Warrior();
        break;
      default:
        throw new RuntimeException("Unknown class");
    }
    pg.setName(name);
    pg.setPay(pay);
    stupidDB.add(pg);
    return pg.getId();
  }

  public ID fire(ID id) {
    stupidDB.remove(id);
    return id;
  }

  public String attack() {
    return getPGs().sorted().map(PlayableCharacter::attack).collect(Collectors.joining(" - "));
  }

  public String defend() {
    return getPGs().sorted().map(PlayableCharacter::defend).collect(Collectors.joining(" - "));
  }

  public double getCost() {
    return getPGs().map(PlayableCharacter::getPay).reduce(0.0, Double::sum);
  }

  private Stream<PlayableCharacter> getPGs() {
    return stupidDB.playableCharacters().stream();
  }
}
