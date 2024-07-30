package steps.menu;

import io.cucumber.java.en.When;
import pages.dataanchor.menu.MenuItems;

public class MenuItemsSteps {

    MenuItems menuItems;
    public MenuItemsSteps(MenuItems menuItems) {
        this.menuItems = menuItems.get();
    }

    @When("The user clicks on {string}:{string} on Menu Items")
    public void clickOnElement(String locator, String elementType) {
        menuItems.clickOnElement(locator, elementType);
    }
}
