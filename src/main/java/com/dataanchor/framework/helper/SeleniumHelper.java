package com.dataanchor.framework.helper;

import com.dataanchor.framework.controls.BrowserWaits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static com.dataanchor.framework.controls.BrowserWaits.*;
import static com.dataanchor.framework.utilities.LogUtil.info;
import static org.openqa.selenium.By.xpath;

public class SeleniumHelper {

  private SeleniumHelper() {
    throw new IllegalStateException("SeleniumHelper class");
  }

  public static WebElement getElement(WebDriver driver, String sLocator) {
    info("Waiting for an element " + sLocator);
    return findElement(driver, sLocator);
  }

  public static WebElement getElementToClick(WebDriver driver, String sLocator) {
    waitForClickableElement.accept(driver, sLocator);
    return findElement(driver, sLocator);
  }

  public static WebElement findElement(WebDriver driver, String sLocator) {
    waitMethod.accept(driver, sLocator);
    return driver.findElement(xpath(sLocator));
  }

  public static List<WebElement> getElements(WebDriver driver, String sLocator) {
    waitMethod.accept(driver, sLocator);
    return driver.findElements(xpath(sLocator));
  }

  public static int getNumberOfWindows(WebDriver driver) {
    var windows = new ArrayList<>(driver.getWindowHandles());
    return windows.size();
  }

  public static ChromeOptions getChromeOptions() {
    return new ChromeOptions();
  }
}
