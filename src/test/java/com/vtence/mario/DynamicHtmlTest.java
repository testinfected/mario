package com.vtence.mario;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

public class DynamicHtmlTest extends WebTest {

    @Test
    public void assertingAnElementExists() {
        open("async-create.html");

        browser.element(By.id("born")).exists();
    }

    @Test
    public void assertingAnElementNoLongerExists() {
        open("async-delete.html");

        browser.element(By.id("ghost")).exists();
        browser.element(By.id("ghost")).isMissing();
    }

    @Test
    public void assertingAnElementTextMatchesAGivenValue() {
        open("async-text-mutation.html");

        browser.element(By.id("mutant")).hasText(containsString("Success"));
    }

    @Test
    public void assertingAnElementIsDisplayed() {
        open("async-visibility.html");

        browser.element(By.id("secret")).isHidden();
        browser.element(By.id("secret")).isShowingOnScreen();
    }

    @Test
    public void assertingAnElementIsEnabled() {
        open("async-enable.html");

        browser.element(By.id("action")).isDisabled();
        browser.element(By.id("action")).isEnabled();
    }
}