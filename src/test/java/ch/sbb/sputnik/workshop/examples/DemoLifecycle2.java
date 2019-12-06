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

class DemoLifecycle2 {

    @RegisterExtension
    static LifeCycleDemoExtension lifeCycleDemoExtension = new LifeCycleDemoExtension();

    @AfterAll
    static void afterAll(TestInfo testInfo) throws Exception {
        System.out.println(String.format("%s -> afterAll\n", getaClass(testInfo)));
    }

    @AfterEach
    void afterEach(TestInfo testInfo) throws Exception {
        System.out.println(String.format("%s -> afterEach\n", getaClass(testInfo)));
    }

    @BeforeAll
    static void beforeAll(TestInfo testInfo) throws Exception {
        System.out.println(String.format("%s -> beforeAll\n", getaClass(testInfo)));
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) throws Exception {
        System.out.println(String.format("%s -> beforeEach\n", getaClass(testInfo)));
    }

    @Test
    void aTest(TestInfo testInfo) {
        System.out.println(String.format("%s -> %s\n", getaClass(testInfo), testInfo.getTestMethod().orElse(null)));
    }

    private static String getaClass(TestInfo testInfo) {
        return testInfo.getTestClass().orElse(Object.class).getSimpleName();
    }
}
