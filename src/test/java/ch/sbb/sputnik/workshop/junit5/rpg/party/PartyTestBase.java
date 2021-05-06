/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.party;

import ch.sbb.sputnik.workshop.junit5.rpg.db.StupidDBTestBase;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Mage;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Rogue;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Warrior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyTestBase extends StupidDBTestBase {

  public Mage createMage(String name, double pay) {
    Mage mage = new Mage();
    mage.setName(name);
    mage.setPay(pay);
    mage.setId(generateID());

    return mage;
  }

  public Rogue createRogue(String name, double pay) {
    Rogue rogue = new Rogue();
    rogue.setName(name);
    rogue.setPay(pay);
    rogue.setId(generateID());

    return rogue;
  }

  public Warrior createWarrior(String name, double pay) {
    Warrior warrior = new Warrior();
    warrior.setName(name);
    warrior.setPay(pay);
    warrior.setId(generateID());

    return warrior;
  }

  public Party createParty() {
    return new Party(getDb());
  }

  public void setPlayableCharacters(ArrayList<PlayableCharacter> playableCharacters) {
    getDb().setPlayableCharacters(playableCharacters);
  }

  public List<PlayableCharacter> playableCharacters() {
    return Collections.unmodifiableList(getDb().playableCharacters());
  }
}
