package pages.dataanchor.menu;

import com.dataanchor.framework.config.Constants;
import com.dataanchor.framework.exceptionhandling.DataAnchorCustomException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import static com.dataanchor.framework.config.Constants.*;
import static com.dataanchor.framework.controls.BrowserValidation.isDisplayed;

public class MenuItems extends BasePage<MenuItems> {

    private static MultiKeyMap<String, String> menuItemsMultiLocs = new MultiKeyMap<>();

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, getLocators("File Name", TEXT))) {
            throw new DataAnchorCustomException("Menu Items did not load Successfully");
        }
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return menuItemsMultiLocs.get(locator, elementType);
    }

    static {
        menuItemsMultiLocs.put("Home", BUTTON, "//button[@id='menu-/home']/*[name()='svg']");
        menuItemsMultiLocs.put("File Name", TEXT, "(//button[@data-state='closed']/span)[2]");
    }
}
