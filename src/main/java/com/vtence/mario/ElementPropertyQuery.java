package com.vtence.mario;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import org.openqa.selenium.WebElement;

public class ElementPropertyQuery<T> implements Query<T>, SelfDescribing {

    private final String propertyName;
    private final Query<T> query;

    public ElementPropertyQuery(String propertyName, Query<T> query) {
        this.propertyName = propertyName;
        this.query = query;
    }

    public T perform(WebElement webElement) {
        return query.perform(webElement);
    }

    public void describeTo(Description description) {
        description.appendText(propertyName);
    }
}
