/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.examples;

import ch.sbb.sputnik.workshop.examples.extension.LifeCycleDemoExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.logging.Logger;

public class DemoLifecycle2 {

    @RegisterExtension
    LifeCycleDemoExtension lifeCycleDemoExtension = new LifeCycleDemoExtension();

    private static Logger logger = Logger.getLogger(DemoLifecycle.class.getTypeName());

    @AfterAll
    public static void afterAll(TestInfo testInfo) throws Exception {
        logger.info(String.format("%s -> afterAll\n", getaClass(testInfo)));
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) throws Exception {
        logger.info(String.format("%s -> afterEach\n", getaClass(testInfo)));
    }

    @BeforeAll
    public static void beforeAll(TestInfo testInfo) throws Exception {
        logger.info(String.format("%s -> beforeAll\n", getaClass(testInfo)));
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo) throws Exception {
        logger.info(String.format("%s -> beforeEach\n", getaClass(testInfo)));
    }

    @Test
    void aTest(TestInfo testInfo) {
        logger.info(String.format("%s -> %s\n", getaClass(testInfo), testInfo.getTestMethod().orElse(null)));
    }

    private static String getaClass(TestInfo testInfo) {
        return testInfo.getTestClass().orElse(Object.class).getSimpleName();
    }
}
