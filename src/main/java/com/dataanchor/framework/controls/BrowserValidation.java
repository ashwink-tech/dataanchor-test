package com.dataanchor.framework.controls;

import org.openqa.selenium.WebDriver;

import static com.dataanchor.framework.controls.BrowserWaits.*;
import static com.dataanchor.framework.helper.SeleniumHelper.getElement;
import static com.dataanchor.framework.helper.SeleniumHelper.getElements;
import static com.dataanchor.framework.utilities.LogUtil.info;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BrowserValidation {

  private BrowserValidation() {
    throw new IllegalStateException("BrowserValidation class");
  }

  private static final String CHECK_ELEMENT_LOG = "Checking whether an element ";

  public static boolean isElementClickable(WebDriver driver, String sLocator) {
    info(CHECK_ELEMENT_LOG + sLocator + " is present");
    getMediumWait.apply(driver).until(elementToBeClickable(getElement(driver,sLocator)));
    return true;
  }

  public static boolean isDisplayed(WebDriver driver, String sLocator) {
    info(CHECK_ELEMENT_LOG + sLocator + " is displayed");
    return getElement(driver, sLocator).isDisplayed();
  }
}
