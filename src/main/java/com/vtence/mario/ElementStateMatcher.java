package com.vtence.mario;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

public class ElementStateMatcher extends TypeSafeMatcher<WebElement> {
    private final Query<Boolean> state;
    private final String stateDescription;
    private final String oppositeStateDescription;

    public ElementStateMatcher(Query<Boolean> state, String stateDescription, String oppositeStateDescription) {
        this.state = state;
        this.stateDescription = stateDescription;
        this.oppositeStateDescription = oppositeStateDescription;
    }

    protected boolean matchesSafely(WebElement element) {
        return state.perform(element);
    }

    public void describeTo(Description description) {
        description.appendText("is ").appendText(stateDescription);
    }

    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendText(oppositeStateDescription);
    }
}
