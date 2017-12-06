package com.vtence.mario;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.not;

public class RobustnessTests extends WebTest {

    @Rule public
    ExpectedException thrown = ExpectedException.none();

    @Test public void
    staleElementsAreReportedMissingInsteadOfCausingExceptions() {
        open("async-stale.html");

        thrown.expect(not(isA(StaleElementReferenceException.class)));
        browser.element(By.id("bye")).has(new ElementPropertyQuery<>("text", element -> {
            // Let element become stale
            browser.pause(500);
            return element.getText();
        }), anything());
    }

    @Test public void
    whenQueryingStateToo() {
        open("async-stale.html");

        thrown.expect(not(isA(StaleElementReferenceException.class)));
        browser.element(By.id("bye")).is(element -> {
            // Let element become stale
            browser.pause(500);
            return element.isDisplayed();
        }, "displayed", "hidden");
    }
}
