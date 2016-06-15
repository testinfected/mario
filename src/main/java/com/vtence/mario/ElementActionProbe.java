package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;

public class ElementActionProbe extends ElementProbe {
    private ElementAction action;

    public ElementActionProbe(ElementSelector selector, ElementAction action) {
        super(selector);
        this.action = action;
    }

    public void probe(WebElement element) {
        action.performOn(element);
    }

    public void describeTo(Description description) {
        action.describeTo(description);
        description.appendText(" ");
        super.describeTo(description);
    }
}
