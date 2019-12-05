/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.examples.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.logging.Logger;

public class LifeCycleDemoExtension
    implements BeforeAllCallback,
        BeforeEachCallback,
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback,
        AfterEachCallback,
        AfterAllCallback {

  private Logger logger = Logger.getLogger(LifeCycleDemoExtension.class.getName());

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    logger.info("LifeCycleDemoExtension -> AfterAll\n");
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    logger.info("LifeCycleDemoExtension -> AfterEach\n");
  }

  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {
    logger.info("LifeCycleDemoExtension -> AfterTestExecution\n");
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    logger.info("LifeCycleDemoExtension -> BeforeAll\n");
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    logger.info("LifeCycleDemoExtension -> BeforeEach\n");
  }

  @Override
  public void beforeTestExecution(ExtensionContext context) throws Exception {
    logger.info("LifeCycleDemoExtension -> BeforeTestExecution\n");
  }
}
