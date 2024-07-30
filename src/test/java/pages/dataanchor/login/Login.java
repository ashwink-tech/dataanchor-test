package pages.dataanchor.login;

import com.dataanchor.framework.exceptionhandling.DataAnchorCustomException;
import com.dataanchor.framework.helper.MailosaurHelper;
import com.mailosaur.MailosaurException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import java.io.IOException;

import static com.dataanchor.framework.controls.BrowserActions.click;
import static com.dataanchor.framework.controls.BrowserNavigation.navigateToUrl;
import static com.dataanchor.framework.controls.BrowserValidation.isDisplayed;
import static com.dataanchor.framework.factories.GetBaseUrlFactory.getBaseUrl;

public class Login extends BasePage<Login> {

    private static MultiKeyMap<String, String> loginMultiLocs = new MultiKeyMap<>();

    public Login() {
        navigateToUrl.accept(driver, getBaseUrl());
    }

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, IP_EMAIL)) {
            throw new DataAnchorCustomException("Login Page was not successfully loaded");
        }
    }

    public void loginIntoApp(String email) throws MailosaurException, IOException, InterruptedException {
        Thread.sleep(5000);
        enterValue(email, IP_EMAIL);
        click(driver, BTN_CONTINUE_EMAIL);
        click(driver, BTN_CONTINUE);
        enterValue(MailosaurHelper.getOTP(), IP_OTP);
        click(driver, BTN_CONTINUE);
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return loginMultiLocs.get(locator, elementType);
    }

    private static final String IP_EMAIL = "//input[@name='email']";
    private static final String IP_OTP = "//input[@id='1-vcode']";

    private static final String BTN_CONTINUE_EMAIL = "//button[@id='email-btn']";

    private static final String BTN_CONTINUE = "//button[@id='1-submit']";
    private static final String IP_PASSWORD  = "//input[@data-test='password']";
    private static final String BTN_LOGIN    = "//input[@data-test='login-button']";
}
