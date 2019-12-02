/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mgmt.party;

import ch.sbb.sputnik.workshop.mgmt.db.ID;
import ch.sbb.sputnik.workshop.mgmt.db.StupidDB;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Mage;
import ch.sbb.sputnik.workshop.mgmt.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Rogue;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Role;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Warrior;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        stupidDB.add(pg);
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
    return stupidDB.playableCharacters().stream()
        .map(PlayableCharacter::attack)
        .sorted(String::compareTo)
        .collect(Collectors.joining(" - "));
  }
}
