package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;

import java.util.function.Consumer;

public class ElementManipulation implements ElementAction {
    private final Consumer<WebElement> manipulation;
    private final String description;

    public ElementManipulation(String description, Consumer<WebElement> manipulation) {
        this.description = description;
        this.manipulation = manipulation;
    }

    public static ElementAction manipulate(String description, Consumer<WebElement> manipulation) {
        return new ElementManipulation(description, manipulation);
    }

    public void performOn(WebElement element) {
        manipulation.accept(element);
    }

    public void describeTo(Description description) {
        description.appendText(this.description);
    }
}