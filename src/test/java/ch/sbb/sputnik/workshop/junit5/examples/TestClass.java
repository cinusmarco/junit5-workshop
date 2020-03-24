/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.examples;

import ch.sbb.sputnik.workshop.junit5.examples.extension.MyExt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class TestClass {

  @RegisterExtension static MyExt myExt = new MyExt();

  @Test
  void t() {
    System.out.println("done.");
  }
}
