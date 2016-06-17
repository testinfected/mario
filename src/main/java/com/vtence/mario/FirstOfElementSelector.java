package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.*;

public class FirstOfElementSelector implements ElementSelector {

    private final SearchContext context;
    private final By criteria;
    private WebElement foundElement;

    public FirstOfElementSelector(SearchContext context, By criteria) {
        this.context = context;
        this.criteria = criteria;
    }

    public WebElement found() {
        return foundElement;
    }

    public void probe() {
        foundElement = null;
        try {
            foundElement = context.findElement(criteria);
        } catch (NotFoundException tryAgain) {
        }
    }

    public boolean isSatisfied() {
        return foundElement != null;
    }

    public void describeTo(Description description) {
        description.appendText("an element ").appendText(formatCriteria());
    }

    private String formatCriteria() {
        return criteria.toString().replaceFirst("By\\.", "by ").replaceFirst(": ", " \"").concat("\"");
    }

    public void describeFailureTo(Description description) {
        description.appendText("did not find matching element");
    }
}
