package steps.files;

import com.dataanchor.framework.browser.Browser;
import com.dataanchor.framework.controls.BrowserCommands;
import com.dataanchor.framework.controls.BrowserIFrames;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.dataanchor.files.Books;

import static com.dataanchor.framework.browser.Browser.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BookSteps {

    Books books;
    public BookSteps(Books books) {
        this.books = books;
    }

    @And("The user switch to the {string}:{string} frame")
    public void switchWindow(String locator, String elementType) {
        BrowserIFrames.switchToIFrame(getDriver.get(), books.getLocators(locator, elementType));
    }

    @Then("Verify current url on {string} Page")
    public void verifyElementPresent(String page) {
       assertThat(BrowserCommands.getCurrentUrl.apply(getDriver.get()))
          .contains(page);
    }

    @Then("Verify {string}:{string} {string} is present on Book Page")
    public void verifyTextPresent(String locator, String elementType, String text) {
        books.isEqualTo(locator, elementType, text);
    }
}
