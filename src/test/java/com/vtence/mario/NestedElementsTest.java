package com.vtence.mario;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.equalTo;

public class NestedElementsTest extends WebTest {
    @Test
    public void navigatingToNestedElements() throws Exception {
        open("nested-elements.html");

        browser.element(By.id("a")).element(By.className("button")).click();
        browser.element(By.id("display")).hasText(equalTo("Button A was pressed"));

        browser.element(By.id("b")).element(By.className("button")).click();
        browser.element(By.id("display")).hasText(equalTo("Button B was pressed"));
    }
}