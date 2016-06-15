package com.vtence.mario;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ElementQuery<T> {

    T query(WebElement element);
}
