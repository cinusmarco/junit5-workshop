/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.rpg.party;

import ch.sbb.sputnik.workshop.rpg.db.StupidDBTestBase;
import ch.sbb.sputnik.workshop.rpg.party.pg.Mage;
import ch.sbb.sputnik.workshop.rpg.party.pg.Rogue;
import ch.sbb.sputnik.workshop.rpg.party.pg.Warrior;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


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

    @BeforeEach
    public void setup() {
        super.initDB();
    }

    @AfterEach
    public void tearDown() {
        super.resetDB();
    }
}
