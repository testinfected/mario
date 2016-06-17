package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public abstract class ElementProbe implements Probe {

    private final ElementSelector selector;
    private boolean stale;

    public ElementProbe(ElementSelector selector) {
        this.selector = selector;
    }

    public void probe() {
        selector.probe();
        if (!selector.isSatisfied()) return;

        try {
            probe(selector.found());
        } catch (StaleElementReferenceException giveUp) {
            stale = true;
        }
    }

    protected abstract void probe(WebElement found);

    public boolean isSatisfied() {
        return selector.isSatisfied() && !stale;
    }

    @Override
    public void describeTo(Description description) {
        selector.describeTo(description);
    }

    @Override
    public void describeFailureTo(Description description) {
        selector.describeFailureTo(description);
    }
}
