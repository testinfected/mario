package com.vtence.mario;

import org.openqa.selenium.interactions.internal.Coordinates;

public class UserGestures {

    public static UserGesture mouseMoveTo(Coordinates where) {
        return robot -> robot.moveMouseTo(where);
    }

    public static UserGesture mouseClick() {
        return GesturePerformer::click;
    }

    public static UserGesture mouseClickAt(Coordinates where) {
        return sequenceOf(mouseMoveTo(where), mouseClick());
    }

    public static UserGesture typeText(CharSequence text) {
        return robot -> robot.type(text);
    }

    public static UserGesture pause(long millis) {
        return robot -> robot.delay(millis);
    }

    public static UserGesture sequenceOf(UserGesture... gestures) {
        return gesturePerformer -> {
            for (UserGesture gesture : gestures) {
                gesturePerformer.perform(gesture);
            }
        };
    }
}
