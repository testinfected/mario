package com.vtence.mario;

import org.openqa.selenium.interactions.internal.Coordinates;

// We'd like to use Points rather than Coordinates, unfortunately RemoteMouse does not make use of locations internally,
// it merely moves the mouse to the coordinates' auxiliary object center. That's too bad because the webdriver protocol
// supports moving the mouse to a given (x, y) position.
public interface GesturePerformer {

    void perform(UserGesture... gestures);

    void moveMouseTo(Coordinates where);

    void mouseClick(Coordinates where);

    void type(String text);

    default void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
