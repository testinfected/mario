package com.vtence.mario;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.internal.Coordinates;

import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;

public class WebElementDriver {

    private final ElementSelector selector;
    private final Prober prober;
    private final GesturePerformer gesturePerformer;

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

    public void is(Query<Boolean> state, String stateDescription, String oppositeStateDescription) {
        is(new ElementStateMatcher(state, stateDescription, oppositeStateDescription));
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

    public void hasAttribute(String name, String value) {
        hasAttribute(name, equalTo(value));
    }

    public void hasAttribute(String name, Matcher<? super String> matching) {
        has(ElementProperties.attribute(name), matching);
    }

    public void hasCssProperty(String propertyName, Matcher<? super String> matching) {
        has(ElementProperties.cssProperty(propertyName), matching);
    }

    public <T> void has(String propertyName, Query<T> property, Matcher<? super T> matching) {
        has(new ElementPropertyQuery<>(propertyName, property), matching);
    }

    public <T> void has(ElementPropertyQuery<T> property, Matcher<? super T> matching) {
        check(new ElementPropertyAssertionProbe<>(selector, property, matching));
    }

    public void click() {
        isShowingOnScreen();
        isEnabled();
        hoverWithMouse();
        apply(ElementActions.click());
    }

    public void submit() {
        apply(ElementActions.submit());
    }

    public void type(CharSequence text) {
        apply(ElementActions.type(text));
    }

    public void clear() {
        apply(ElementActions.clear());
    }

    public <T> T query(String description, Query<T> query) {
        QueryManipulation<T> manipulation = new QueryManipulation<T>(query);
        manipulate(format("query %s of", description), manipulation);
        return manipulation.value();
    }

    public void manipulate(String description, Manipulation manipulation) {
        apply(ElementManipulation.manipulate(description, manipulation));
    }

    public void apply(ElementAction action) {
        check(new ElementActionProbe(selector, action));
    }

    public Coordinates elementLocation() {
        ElementLocationProbe location = new ElementLocationProbe(selector);
        check(location);
        return location.coordinates();
    }

    public void hoverWithMouse() {
        perform(UserGestures.mouseMoveTo(elementLocation()));
    }

    public void leftClickWithMouse() {
        isShowingOnScreen();
        isEnabled();
        perform(UserGestures.mouseClickAt(elementLocation()));
    }

    public void enterTextUsingKeyboard(CharSequence text) {
        leftClickWithMouse();
        perform(UserGestures.typeText(text));
    }

    public void perform(UserGesture... gestures) {
        gesturePerformer.perform(gestures);
    }

    public WebElementDriver element(By criteria) {
        return new WebElementDriver(new NestedElementLocator(selector, criteria), prober, gesturePerformer);
    }

    private void check(Probe probe) {
        prober.check(probe);
    }
}
