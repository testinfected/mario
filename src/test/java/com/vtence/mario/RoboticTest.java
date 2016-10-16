package com.vtence.mario;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.openqa.selenium.By.id;

public class RoboticTest extends WebTest {

    @Test public void
    initiatingDynamicBehaviourWithAUserGesture() {
        open("button-click.html");

        browser.element(id("button")).leftClickWithMouse();
        browser.element(id("display")).hasText(containsString("Success!"));
    }

    @Test public void
    revealingThenInteractingWithAHiddenElement() {
        open("hover-menu.html");

        browser.element(id("menu")).hoverWithMouse();
        browser.element(id("button")).click();
        browser.element(id("display")).hasText("Success!");
    }

    @Test public void
    typingText() {
        open("text-entry.html");

        browser.element(id("input")).enterTextUsingKeyboard("hello world\n");
        browser.element(id("reversed")).hasText("dlrow olleh");
    }
}
