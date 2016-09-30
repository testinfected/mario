package com.vtence.mario;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface Manipulation {

    void manipulate(WebElement element);
}
