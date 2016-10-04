package com.vtence.mario;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

public class ElementAssertionProbe extends ElementProbe {
    private final Matcher<WebElement> assertion;
    private WebElement found;

    public ElementAssertionProbe(ElementSelector selector, ElementStateMatcher assertion) {
        super(selector);
        this.assertion = assertion;
    }

    protected void probe(WebElement found) {
        this.found = found;
    }

    public boolean isSatisfied() {
        return super.isSatisfied() && assertion.matches(found);
    }

    public void describeTo(Description description) {
        description.appendText("check that ");
        super.describeTo(description);
        description.appendText(" ").appendDescriptionOf(assertion);
    }

    public void describeFailureTo(Description description) {
        if (!super.isSatisfied()) {
            super.describeFailureTo(description);
        } else {
            description.appendText("it ");
            assertion.describeMismatch(found, description);
        }
    }
}
