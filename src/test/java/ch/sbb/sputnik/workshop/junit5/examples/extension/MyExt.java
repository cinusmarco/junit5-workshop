/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.examples.extension;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyExt implements BeforeAllCallback, BeforeEachCallback {

  private int anInt = 42;
  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    System.out.println("beforeAll invoked...");
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    System.out.println("beforeEach invoked...");
  }

  public int getAnInt() {
    return anInt;
  }
}
