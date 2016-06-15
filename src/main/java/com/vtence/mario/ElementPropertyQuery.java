package com.vtence.mario;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import org.openqa.selenium.WebElement;

public class ElementPropertyQuery<T> implements ElementQuery<T>, SelfDescribing {

    private final String propertyName;
    private final ElementQuery<T> query;

    public ElementPropertyQuery(String propertyName, ElementQuery<T> query) {
        this.propertyName = propertyName;
        this.query = query;
    }

    public T query(WebElement webElement) {
        return query.query(webElement);
    }

    public void describeTo(Description description) {
        description.appendText(propertyName);
    }
}
