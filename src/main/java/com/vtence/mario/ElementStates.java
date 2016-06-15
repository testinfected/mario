package com.vtence.mario;

import org.openqa.selenium.WebElement;

public class ElementStates {
    public static ElementStateMatcher displayed() {
        return new ElementStateMatcher(WebElement::isDisplayed, "displayed", "hidden");
    }

    public static ElementStateMatcher enabled() {
        return new ElementStateMatcher(WebElement::isEnabled, "enabled", "disabled");
    }

    public static ElementStateMatcher hidden() {
        return new ElementStateMatcher(element -> !element.isDisplayed(), "hidden", "displayed");
    }
}
