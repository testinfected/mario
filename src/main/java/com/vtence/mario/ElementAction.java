package com.vtence.mario;

import org.hamcrest.SelfDescribing;
import org.openqa.selenium.WebElement;

public interface ElementAction extends SelfDescribing {

    void performOn(WebElement element);
}