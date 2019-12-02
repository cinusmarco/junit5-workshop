/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mgmt.db;

import org.junit.After;
import org.junit.Before;

public class StupidDBTestBase {

  protected StupidDB db;

  protected static ID generateID() {
    return ID.generate();
  }

  @Before
  public void initDB() {
    db = new StupidDB();
  }

  @After
  public void resetDB() {
    db.playableCharacters.clear();
  }
}
