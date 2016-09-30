package com.vtence.mario;

import org.openqa.selenium.WebElement;

public class QueryManipulation<T> implements Manipulation {
    private final Query<T> query;
    private T value;

    public QueryManipulation(Query<T> query) {
        this.query = query;
    }

    public void manipulate(WebElement webElement) {
        value = query.perform(webElement);
    }

    public T value() {
        return value;
    }
}
