package com.vtence.mario;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

public class ElementPropertyAssertionProbe<T> extends ElementProbe {

    private final ElementPropertyQuery<T> query;
    private final Matcher<? super T> matcher;
    private T value = null;

    public ElementPropertyAssertionProbe(ElementSelector selector,
                                         ElementPropertyQuery<T> query,
                                         Matcher<? super T> matcher) {

        super(selector);
        this.query = query;
        this.matcher = matcher;
    }

    public void probe(WebElement element) {
        value = query.perform(element);
    }

    public boolean isSatisfied() {
        return super.isSatisfied() && matcher.matches(value);
    }

    public void describeTo(Description description) {
        description.appendText("look for ");
        super.describeTo(description);
        description.appendText(" with ")
                   .appendDescriptionOf(query)
                   .appendText(" ")
                   .appendDescriptionOf(matcher);

    }

    public void describeFailureTo(Description description) {
        if (!super.isSatisfied()) {
            super.describeFailureTo(description);
        } else {
            description.appendText("its ")
                       .appendDescriptionOf(query)
                       .appendText(" ");
            matcher.describeMismatch(value, description);
        }
    }
}
