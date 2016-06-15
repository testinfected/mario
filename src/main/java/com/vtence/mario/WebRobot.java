package com.vtence.mario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.stream.Stream;

public class WebRobot implements GesturePerformer {
    private final WebDriver driver;

    public WebRobot(WebDriver driver) {
        this.driver = driver;
    }

    public void perform(UserGesture... gestures) {
        Stream.of(gestures).forEach(gesture -> gesture.performUsing(this));
    }

    public void moveMouseTo(Coordinates where) {
        mouse().mouseMove(where);
    }

    public void mouseClick(Coordinates where) {
        mouse().click(where);
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
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
