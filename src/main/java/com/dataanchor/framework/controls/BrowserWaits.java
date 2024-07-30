package com.dataanchor.framework.controls;

import com.dataanchor.framework.config.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.dataanchor.framework.controls.BrowserValidation.isElementClickable;
import static com.dataanchor.framework.helper.SeleniumHelper.getElement;
import static com.dataanchor.framework.helper.WaitHelper.pollInterval;
import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BrowserWaits {

    private BrowserWaits() {
        throw new IllegalStateException("BrowserWaits class");
    }

    public static final Function<WebDriver, WebDriverWait> getLongWait =
      driver -> new WebDriverWait(driver, ofSeconds(Constants.LONG_WAIT));

    public static final Function<WebDriver, WebDriverWait> getMediumWait =
      driver -> new WebDriverWait(driver, ofSeconds(Constants.MEDIUM_WAIT));

    public static final BiConsumer<WebDriverWait, String> waitForPresence = (wait, sLocator) -> {
        wait.until(visibilityOfElementLocated(xpath(sLocator)));
        wait.until(presenceOfElementLocated(xpath(sLocator)));
      };

    public static final BiConsumer<WebDriver, String> waitMethod = (driver, sLocator) ->
        waitForPresence.accept(getLongWait.apply(driver), sLocator);

    public static final Consumer<WebDriver> waitForWindowsToBeAvailable =
       driver -> getLongWait.apply(driver).until(numberOfWindowsToBe(2));

    public static final BiConsumer<WebDriver, String> waitForFrameToBeAvailableAndSwitch =
       (driver, sLocator) -> getLongWait.apply(driver)
       .until(frameToBeAvailableAndSwitchToIt(getElement(driver, sLocator)));

    public static final Consumer<WebDriver> waitForCurrentUrl =
        driver -> getLongWait.apply(driver).until(urlContains("http"));

    public static final BiConsumer<WebDriver, String> waitForClickableElement =
      (driver, sLocator) -> pollInterval
        .apply("Waiting for an element to be clickable")
        .ignoreExceptions()
        .untilAsserted(() -> assertThat(isElementClickable(driver, sLocator)).isTrue());

}
