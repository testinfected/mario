package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;

public class ExistingElementProbe extends ElementProbe {
    public ExistingElementProbe(ElementSelector selector) {
        super(selector);
    }

    protected void probe(WebElement found) {
        // nothing to do
    }

    public void describeTo(Description description) {
        description.appendText("look for ");
        super.describeTo(description);
    }
}
