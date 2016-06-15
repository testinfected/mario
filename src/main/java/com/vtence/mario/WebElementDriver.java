package com.vtence.mario;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.function.Consumer;

import static org.hamcrest.Matchers.equalTo;

public class WebElementDriver {

    private final ElementSelector selector;
    private final Prober prober;
    private final GesturePerformer gesturePerformer;
    private boolean hidden;

    public WebElementDriver(ElementSelector selector, Prober prober, GesturePerformer gesturePerformer) {
        this.selector = selector;
        this.prober = prober;
        this.gesturePerformer = gesturePerformer;
    }

    public void exists() {
        check(new ExistingElementProbe(selector));
    }

    public void isMissing() {
        check(new MissingElementProbe(selector));
    }

    public void isShowingOnScreen() {
        is(ElementStates.displayed());
    }

    public void isHidden() {
        is(ElementStates.hidden());
    }

    public void isEnabled() {
        is(ElementStates.enabled());
    }

    public void isDisabled() {
        is(ElementStates.disabled());
    }

    public void is(ElementStateMatcher state) {
        check(new ElementAssertionProbe(selector, state));
    }

    public void hasText(String text) {
        hasText(equalTo(text));
    }

    public void hasText(Matcher<? super String> matching) {
        has(ElementProperties.text(), matching);
    }

    public <T> void has(ElementPropertyQuery<T> property, Matcher<? super T> matching) {
        check(new ElementPropertyAssertionProbe<>(selector, property, matching));
    }

    public void click() {
        isShowingOnScreen();
        isEnabled();
        apply(ElementActions.click());
    }

    public void type(String text) {
        apply(ElementActions.type(text));
    }

    public void manipulate(String description, Consumer<WebElement> manipulation) {
        apply(ElementManipulation.manipulate(description, manipulation));
    }

    public void apply(ElementAction action) {
        check(new ElementActionProbe(selector, action));
    }

    public Coordinates elementCenter() {
        ElementLocationProbe coordinates = new ElementLocationProbe(selector);
        check(coordinates);
        return coordinates.center();
    }

    public void check(Probe probe) {
        prober.check(probe);
    }

    public void moveMouseToCenter() {
        perform(UserGestures.mouseMoveTo(elementCenter()));
    }

    public void leftClickWithMouse() {
        isShowingOnScreen();
        perform(UserGestures.mouseClickAt(elementCenter()));
    }

    public void perform(UserGesture gesture) {
        gesturePerformer.perform(gesture);
    }
}
