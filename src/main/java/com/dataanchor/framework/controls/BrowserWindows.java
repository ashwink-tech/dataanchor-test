package com.dataanchor.framework.controls;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static com.dataanchor.framework.controls.BrowserCommands.*;
import static com.dataanchor.framework.controls.BrowserWaits.*;
import static com.dataanchor.framework.helper.SeleniumHelper.*;
import static com.dataanchor.framework.utilities.LogUtil.info;

public class BrowserWindows {

    private BrowserWindows() {
        throw new IllegalStateException("BrowserWindows class");
    }

    public static void switchToWindow(WebDriver driver) {
            waitForWindowsToBeAvailable.accept(driver);

            info("Switching To Window");
            var windowHandle = driver.getWindowHandle();
            var windows = new ArrayList<>(driver.getWindowHandles());
            windows.remove(windowHandle);
            driver.switchTo().window(windows.get(0));

            waitForCurrentUrl.accept(driver);
    }

    public static void switchBackFromWindow(WebDriver driver) {
        var windowHandles=driver.getWindowHandles().toArray();

        info("Switching Outside Window");
            if (getNumberOfWindows(driver) > 1) {
                closeBrowserTab.accept(driver);
            }
        driver.switchTo().window((String) windowHandles[0]);
    }
}
