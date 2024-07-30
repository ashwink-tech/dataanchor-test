package steps.sections;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dataanchor.sections.SharedPage;

public class SharedPageSteps {

    SharedPage sharedPage;
    public SharedPageSteps(SharedPage sharedPage) {
        this.sharedPage = sharedPage.get();
    }

    @When("The user clicks on {string}:{string} on Shared Page")
    public void clickOnElement(String locator, String elementType) {
        sharedPage.clickOnElement(locator, elementType);
    }

    @Then("Verify {string}:{string} {string} is present on Shared Page")
    public void verifyElementNotDisplayed(String locator, String elementType, String text) {
        sharedPage.isEqualTo(locator, elementType, text);
    }
}
