[![Build Status](https://travis-ci.org/testinfected/mario.svg?branch=master)](https://travis-ci.org/testinfected/mario)


Mario
=============
Licensed under the [BSD License][].


What is Mario?
--------------
Mario is java library intended to simplify asynchronous testing with [Selenium WebDriver][].

It takes care of the activity of polling for certain conditions or states to occur and manages timeouts, replacing the need for explicit or implicit waits.


With Mario you can do:

```java
BrowserDriver browser = new BrowserDriver(new UnsynchronizedProber(1000, 50), new FirefoxDriver());
browser.navigate().to("http://somedomain/url_that_delays_loading");
browser.element(By.id("some-dynamic-element")).hasText("Loaded");
browser.element(By.id("some-button")).click();
```

instead of:
```java
WebDriver driver = new FirefoxDriver();
driver.get("http://somedomain/url_that_delays_loading");
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement display = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("some-dynamic-element")));
assertThat("display text", display.getText(), equalTo("Loaded"))
WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("some-button")));
button.click()

```

Plus you get nice diagnostics messages like:

```java
java.lang.AssertionError:
Tried to:
    check that an element by id "some-button" is enabled
but:
    it was disabled
```


Downloads
---------
Grab the latest Mario binaries from [Maven central][].

You can obtain development versions from [Sonatype Snapshots Repositories][].

Report issues using [GitHub issue tracker][].


Acknowledgements
----------------
Mario was inspired by Windowlicker.


[BSD License]: http://opensource.org/licenses/BSD-3-Clause
[Selenium WebDriver]: http://www.seleniumhq.org/projects/webdriver/
[Maven central]: http://search.maven.org/#search%7Cga%7C1%7Ccom.vtence.mario
[Sonatype Snapshots Repositories]: https://oss.sonatype.org/content/repositories/snapshots
[GitHub issue tracker]: https://github.com/testinfected/mario/issues