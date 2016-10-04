package com.vtence.mario;

import org.openqa.selenium.WebElement;

import static com.vtence.mario.ElementManipulation.manipulate;

public class ElementActions {
    public static ElementAction click() {
        return manipulate("click on", WebElement::click);
    }

    public static ElementAction type(CharSequence text) {
        return manipulate("type text in", element -> element.sendKeys(text));
    }

    public static ElementAction clear() {
        return manipulate("clear content of", WebElement::clear);
    }
}
