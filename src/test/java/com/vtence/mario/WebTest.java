package com.vtence.mario;

import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public abstract class WebTest {

    protected BrowserDriver browser = new BrowserDriver(new UnsynchronizedProber(1000, 50), new ChromeDriver());

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    protected void open(String htmlPage) {
        URL location = this.classLoader.getResource(htmlPage);
        if(location == null) {
            throw new IllegalArgumentException("Cannot find test resource " + htmlPage);
        }
        browser.navigate().to(location);
    }

    @After
    public void quitBrowser() {
        browser.quit();
    }
}
