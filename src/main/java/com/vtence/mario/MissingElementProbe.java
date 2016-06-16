package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;

public class MissingElementProbe extends ElementProbe {

    public MissingElementProbe(ElementSelector selector) {
        super(selector);
    }

    protected void probe(WebElement found) {
        // nothing to do
    }

    public boolean isSatisfied() {
        return !super.isSatisfied();
    }

    public void describeTo(Description description) {
        description.appendText("check that");
        super.describeTo(description);
        description.appendText(" did not exist");
    }

    public void describeFailureTo(Description description) {
        description.appendText("it did exist");
    }
}
