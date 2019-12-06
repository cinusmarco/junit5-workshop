/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.examples;

import ch.sbb.sputnik.workshop.examples.extension.MyExt2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class TestClass {

  @RegisterExtension static MyExt2 myExt = new MyExt2();

  public TestClass() {
    System.out.println("Constructor");
  }

  @Test
  void t() {
    System.out.println("done. " + myExt.getAnInt());
  }

  @Test
  void t2() {
    System.out.println("2 done.");
  }
}
