package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static com.dataanchor.framework.browser.Browser.*;
import static com.dataanchor.framework.controls.BrowserCommands.closeBrowser;
import static com.dataanchor.framework.controls.BrowserExtraction.getConsoleLogs;
import static com.dataanchor.framework.helper.CucumberHelper.addScenario;
import static com.dataanchor.framework.utilities.LogUtil.info;
import static com.dataanchor.framework.utilities.ScreenShotUtil.captureScreen;

public class Hooks {

  @Before("@dataanchor")
  public void setUpBrowser(Scenario scenario) {
    info("Running before step for scenario : {}", scenario.getName());
    addScenario(scenario.getName());
    setBrowser();
  }

  public static void setBrowser() {
    setBrowser.accept(System.getProperty("browser"));
  }

  @After
  public void afterFeature(Scenario scenario) throws IOException {
    info("Running the General After Hook for scenario : {}", scenario.getName());

    /*Captures Screenshot and embeds it to the Cucumber Report.
    Also Logs Console Errors into the report*/
    if (getDriver.get()!=null) {
      if (scenario.isFailed() && scenario.getName() != null) {
        byte[] screenShot = captureScreen(scenario.getName(), getDriver.get());
        if (screenShot != null) {
          scenario.attach(screenShot, "image/png", scenario.getName());
        }
        getConsoleLogs().forEach(logEntry -> scenario.log(logEntry.toString()));
      }

      closeBrowser.accept(getDriver.get());
      removeWebdriver();
    }
  }
}
