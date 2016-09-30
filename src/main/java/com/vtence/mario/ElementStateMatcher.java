package com.vtence.mario;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

public class ElementStateMatcher extends TypeSafeMatcher<WebElement> {
    private final Query<Boolean> query;
    private final String stateDescription;
    private final String oppositeStateDescription;

    public ElementStateMatcher(Query<Boolean> query, String stateDescription, String oppositeStateDescription) {
        this.query = query;
        this.stateDescription = stateDescription;
        this.oppositeStateDescription = oppositeStateDescription;
    }

    protected boolean matchesSafely(WebElement element) {
        return query.perform(element);
    }

    public void describeTo(Description description) {
        description.appendText("is ").appendText(stateDescription);
    }

    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendText(oppositeStateDescription);
    }
}
