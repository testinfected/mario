package com.vtence.mario;

import org.openqa.selenium.interactions.internal.Coordinates;

public class UserGestures {

    public static UserGesture mouseMoveTo(Coordinates where) {
        return (robot) -> robot.moveMouseTo(where);
    }

    public static UserGesture mouseClickAt(Coordinates where) {
        return (robot) -> robot.mouseClick(where);
    }

    public static UserGesture typeText(String text) {
        return (robot) -> robot.type(text);
    }

    public static UserGesture pause(long millis) {
        return (robot) -> robot.delay(millis);
    }
}
