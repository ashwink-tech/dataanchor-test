package steps;

import com.dataanchor.framework.browser.Browser;
import com.dataanchor.framework.controls.BrowserCommands;
import com.dataanchor.framework.controls.BrowserWindows;
import io.cucumber.java.en.And;

import static com.dataanchor.framework.browser.Browser.*;
import static com.dataanchor.framework.controls.BrowserWindows.*;

public class CommonSteps {

    @And("The user switch the window")
    public void switchWindow() {
        switchToWindow(getDriver.get());
    }

    @And("The user switch to the original window")
    public void switchToOriginalWindow() {
        switchBackFromWindow(getDriver.get());
    }

    @And("The user close the current window")
    public void closeBrowserTab() {
        BrowserCommands.closeBrowserTab.accept(getDriver.get());
    }
}
