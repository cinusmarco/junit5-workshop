/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.examples.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LifeCycleDemoExtension
    implements BeforeAllCallback,
        BeforeEachCallback,
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback,
        AfterEachCallback,
        AfterAllCallback {

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    System.out.println("LifeCycleDemoExtension -> AfterAll\n");
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    System.out.println("LifeCycleDemoExtension -> AfterEach\n");
  }

  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {
    System.out.println("LifeCycleDemoExtension -> AfterTestExecution\n");
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    System.out.println("LifeCycleDemoExtension -> BeforeAll\n");
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    System.out.println("LifeCycleDemoExtension -> BeforeEach\n");
  }

  @Override
  public void beforeTestExecution(ExtensionContext context) throws Exception {
    System.out.println("LifeCycleDemoExtension -> BeforeTestExecution\n");
  }
}
