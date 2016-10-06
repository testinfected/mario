package com.vtence.mario;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

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
        open("async-display.html");

        browser.element(By.id("secret")).isHidden();
        browser.element(By.id("secret")).isShowingOnScreen();
    }

    @Test
    public void assertingAnElementIsEnabled() {
        open("async-enable.html");

        browser.element(By.id("action")).isDisabled();
        browser.element(By.id("action")).isEnabled();
    }

    @Test
    public void assertingAnElementState() {
        open("async-visible.html");

        browser.element(By.id("action")).is(element -> {
            try {
                element.click();
                return true;
            } catch (WebDriverException notClickable) {
                return false;
            }
        }, "clickable", "not clickable");
    }

    @Test
    public void assertingAnElementCssProperty() {
        open("async-visible.html");

        browser.element(By.id("action")).hasCssProperty("visibility", equalTo("hidden"));
        browser.element(By.id("action")).hasCssProperty("visibility", equalTo("visible"));
    }

    @Test
    public void assertingAnElementProperty() {
        open("async-visible.html");

        browser.element(By.id("action")).has("dimension", WebElement::getSize, equalTo(new Dimension(80, 20)));
    }
}