package com.vtence.mario;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.equalTo;

public class NestedElementsTest extends WebTest {
    @Test
    public void navigatingToNestedElements() throws Exception {
        open("nested-elements.html");

        WebElementDriver display = browser.element(By.id("display"));
        WebElementDriver buttonA = browser.element(By.id("a")).element(By.className("button"));
        WebElementDriver buttonB = browser.element(By.id("b")).element(By.className("button"));

        buttonA.click();
        display.hasText(equalTo("Button A was pressed"));

        buttonB.click();
        display.hasText(equalTo("Button B was pressed"));
    }
}