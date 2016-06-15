package com.vtence.mario;

import org.openqa.selenium.WebElement;

public class ElementProperties {

    public static ElementPropertyQuery<String> text() {
        return new ElementPropertyQuery<>("text", WebElement::getText);
    }
}
