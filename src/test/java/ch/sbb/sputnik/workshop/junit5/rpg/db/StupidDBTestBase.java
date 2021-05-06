/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.db;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class StupidDBTestBase implements BeforeEachCallback, AfterEachCallback {

  private StupidDB db;

  public ID generateID() {
    return ID.generate();
  }

  public StupidDB getDb() {
    return db;
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    System.out.println("Clear DB");
    db.playableCharacters.clear();
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    System.out.println("Setting Up DB");
    db = new StupidDB();
  }
}
