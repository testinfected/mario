package com.vtence.mario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserDriver {

    private final Prober prober;
    private final WebDriver webDriver;
    private final GesturePerformer gesturePerformer;

    public BrowserDriver(Prober prober, WebDriver webDriver) {
        this.prober = prober;
        this.webDriver = webDriver;
        this.gesturePerformer = new WebRobot(webDriver);
    }

    public WebDriver.Navigation navigate() {
        return webDriver.navigate();
    }

    public WebElementDriver element(By criteria) {
        return new WebElementDriver(new ElementLocator(webDriver, criteria), prober, gesturePerformer);
    }

    /**
     * For the times we can't avoid it
     */
    public void pause(long millis) {
        gesturePerformer.perform(UserGestures.pause(millis));
    }

    public void quit() {
        webDriver.quit();
    }
}
