/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mgmt.party;

import ch.sbb.sputnik.workshop.mgmt.db.StupidDBTestBase;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Mage;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Rogue;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Warrior;
import org.junit.After;
import org.junit.Before;

public class PartyTestBase extends StupidDBTestBase {

  public static Mage createMage(String name, double pay) {
    Mage mage = new Mage();
    mage.setName(name);
    mage.setPay(pay);
    mage.setId(generateID());

    return mage;
  }

  public static Rogue createRogue(String name, double pay) {
    Rogue rogue = new Rogue();
    rogue.setName(name);
    rogue.setPay(pay);
    rogue.setId(generateID());

    return rogue;
  }

  public static Warrior createWarrior(String name, double pay) {
    Warrior warrior = new Warrior();
    warrior.setName(name);
    warrior.setPay(pay);
    warrior.setId(generateID());

    return warrior;
  }

  @Before
  public void setup() {
    super.initDB();
  }

  @After
  public void tearDown() {
    super.resetDB();
  }
}
