package com.vtence.mario;

import org.openqa.selenium.WebElement;

import static com.vtence.mario.ElementManipulation.manipulate;

public class ElementActions {
    public static ElementAction click() {
        return manipulate("click on", WebElement::click);
    }

    public static ElementAction type(String text) {
        return manipulate("type text in", element -> element.sendKeys(text));
    }
}
