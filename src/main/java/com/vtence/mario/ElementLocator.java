package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ElementLocator implements ElementSelector {

    private final SearchContext context;
    private final By criteria;
    private WebElement foundElement;

    public ElementLocator(SearchContext context, By criteria) {
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

    public void describeFailureTo(Description description) {
        description.appendText("did not find any element ").appendText(formatCriteria());
    }

    private String formatCriteria() {
        return criteria.toString().replaceFirst("By\\.", "by ").replaceFirst(": ", " \"").concat("\"");
    }
}
