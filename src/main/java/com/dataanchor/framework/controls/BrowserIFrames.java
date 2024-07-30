package com.dataanchor.framework.controls;

import org.openqa.selenium.WebDriver;

import static com.dataanchor.framework.controls.BrowserWaits.*;
import static com.dataanchor.framework.utilities.LogUtil.info;

public class BrowserIFrames {

    private BrowserIFrames() {
        throw new IllegalStateException("BrowserIFrames class");
    }

    public static void switchToIFrame(WebDriver driver, String sLocator) {
        info("Switching to the Frame " + sLocator);
        waitMethod.andThen(waitForFrameToBeAvailableAndSwitch).accept(driver, sLocator);
    }
}
