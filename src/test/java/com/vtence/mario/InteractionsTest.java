package com.vtence.mario;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class InteractionsTest extends WebTest {

    @Test public void
    initiatingDynamicBehaviourWithUserAction() {
        open("button-click.html");

        browser.element(id("button")).click();
        browser.element(id("display")).hasText(containsString("Success!"));
    }

    @Test public void
    interactingWithDynamicContent() {
        open("dynamic-button.html");

        browser.element(id("display")).hasText("Waiting to start");
        browser.element(id("start")).click();
        browser.element(id("display")).hasText("In progress...");
        browser.element(id("stop")).click();
        browser.element(id("display")).hasText("Stopped.");
    }

    @Test public void
    submittingAForm() {
        open("form-submission.html");

        browser.element(tagName("form")).submit();
        browser.element(id("display")).hasText("Success!");
    }

    @Test public void
    typingText() {
        open("text-entry.html");

        browser.element(id("input")).type("hello world");
        browser.element(id("reversed")).hasText("dlrow olleh");
        browser.element(id("input")).clear();
        browser.element(id("input")).type(Keys.RETURN);
        browser.element(id("reversed")).hasText("");
    }

    @Test public void
    manipulatingAnElement() {
        open("text-entry.html");

        browser.element(id("input")).type("hello world");
        browser.element(id("input")).manipulate("clear content of", WebElement::clear);
        browser.element(id("input")).hasText("");
    }

    @Test public void
    queryingAnElement() {
        open("async-create.html");

        assertThat("element text", browser.element(tagName("p")).query("text", WebElement::getText), equalTo("Success!"));
    }
}
