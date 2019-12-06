/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.rpg.db;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class StupidDBTestBase {

    protected StupidDB db;

    protected static ID generateID() {
        return ID.generate();
    }

    @BeforeEach
    public void initDB() {
        db = new StupidDB();
    }

    @AfterEach
    public void resetDB() {
        db.playableCharacters.clear();
    }
}
