package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;

public class ElementManipulation implements ElementAction {
    private final Manipulation manipulation;
    private final String description;

    public ElementManipulation(String description, Manipulation manipulation) {
        this.description = description;
        this.manipulation = manipulation;
    }

    public static ElementAction manipulate(String description, Manipulation manipulation) {
        return new ElementManipulation(description, manipulation);
    }

    public void performOn(WebElement element) {
        manipulation.manipulate(element);
    }

    public void describeTo(Description description) {
        description.appendText(this.description);
    }
}