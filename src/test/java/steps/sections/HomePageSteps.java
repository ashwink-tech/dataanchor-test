package steps.sections;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dataanchor.sections.HomePage;

public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage.get();
    }

    @When("The user enters {string} in {string}:{string} on Home Page")
    public void enterInformation(String inputValue, String locator, String elementType) {
        homePage.enterValue(inputValue, homePage.getLocators(locator, elementType));
    }

    @Then("Verify {string}:{string} {string} is present on Home Page")
    public void verifyTextPresent(String locator, String elementType, String text) {
        homePage.isEqualTo(locator, elementType, text);
    }
}
