package com.vtence.mario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;

public class WebRobot implements GesturePerformer {
    private final WebDriver driver;

    public WebRobot(WebDriver driver) {
        this.driver = driver;
    }

    public void moveMouseTo(Coordinates where) {
        mouse().mouseMove(where);
    }

    public void click() {
        mouse().click(null);
    }

    public void type(CharSequence text) {
        keyboard().sendKeys(text);
    }

    private Keyboard keyboard() {
        return inputDevices().getKeyboard();
    }

    private Mouse mouse() {
        return inputDevices().getMouse();
    }

    private HasInputDevices inputDevices() {
        if (!(driver instanceof HasInputDevices)) {
            throw new UnsupportedOperationException("Driver has no input device");
        }
        return (HasInputDevices) driver;
    }
}
