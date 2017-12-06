package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class NestedElementFinder implements ElementSelector {

    private final By criteria;
    private final ElementSelector parent;

    private WebElement foundElement;

    public NestedElementFinder(ElementSelector parent, By criteria) {
        this.parent = parent;
        this.criteria = criteria;
    }

    public WebElement found() {
        return foundElement;
    }

    public void probe() {
        foundElement = null;

        parent.probe();
        if (!parent.isSatisfied()) return;

        try {
            foundElement = parent.found().findElement(criteria);
        } catch (NotFoundException tryAgain) {
        }
    }

    public boolean isSatisfied() {
        return foundElement != null;
    }

    public void describeTo(Description description) {
        description.appendText("an element ").appendText(formatCriteria())
                   .appendText(", in ")
                   .appendDescriptionOf(parent);
    }

    private String formatCriteria() {
        return criteria.toString().replaceFirst("By\\.", "by ").replaceFirst(": ", " \"").concat("\"");
    }

    public void describeFailureTo(Description description) {
        if (!parent.isSatisfied()) {
            parent.describeFailureTo(description);
        } else {
            description.appendText("did not find any element ")
                       .appendText(formatCriteria())
                       .appendText(" inside ")
                       .appendDescriptionOf(parent);
        }
    }
}
