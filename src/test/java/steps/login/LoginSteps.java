package steps.login;

import com.mailosaur.MailosaurException;
import io.cucumber.java.en.When;
import pages.dataanchor.login.Login;

import java.io.IOException;

public class LoginSteps {

    Login login;

    public LoginSteps(Login login) {
        this.login = login.get();
    }

    @When("The user with email {string} is logging into the app")
    public void theUserWithEmailIsLoggingIntoTheApp(String email) throws MailosaurException, IOException, InterruptedException {
        login.loginIntoApp(email);
        Thread.sleep(10000);
    }
}
