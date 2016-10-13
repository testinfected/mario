package com.vtence.mario;

import org.openqa.selenium.WebElement;

public class ElementProperties {

    public static ElementPropertyQuery<String> text() {
        return new ElementPropertyQuery<>("text", WebElement::getText);
    }

    public static ElementPropertyQuery<String> cssProperty(String propertyName) {
        return new ElementPropertyQuery<>("css property '" + propertyName + "'", e -> e.getCssValue(propertyName));
    }

    public static ElementPropertyQuery<String> attribute(String name) {
        return new ElementPropertyQuery<>("attribute '" + name + "'", e -> e.getAttribute(name));
    }
}
