package com.vtence.mario;

import org.hamcrest.Description;
import org.openqa.selenium.WebElement;

public abstract class ElementProbe implements Probe {

    private final ElementSelector selector;

    public ElementProbe(ElementSelector selector) {
        this.selector = selector;
    }

    public void probe() {
        selector.probe();
        if (selector.isSatisfied()) {
            probe(selector.found());
        }
    }

    protected abstract void probe(WebElement found);

    public boolean isSatisfied() {
        return selector.isSatisfied();
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
