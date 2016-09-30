package com.vtence.mario;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface Query<T> {

    T perform(WebElement element);
}
