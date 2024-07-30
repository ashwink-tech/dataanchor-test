package pages.dataanchor.sections;

import com.dataanchor.framework.exceptionhandling.DataAnchorCustomException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import static com.dataanchor.framework.config.Constants.INPUT;
import static com.dataanchor.framework.config.Constants.TEXT;
import static com.dataanchor.framework.controls.BrowserValidation.isDisplayed;

public class HomePage extends BasePage<HomePage> {

    private static MultiKeyMap<String, String> homePageMultiLocs = new MultiKeyMap<>();

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, getLocators("Search", INPUT))) {
            throw new DataAnchorCustomException("Shared Page was not successfully loaded");
        }
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return homePageMultiLocs.get(locator, elementType);
    }

    static {
        homePageMultiLocs.put("Search", INPUT, "//input[@type='search']");
        homePageMultiLocs.put("File Name", TEXT, "(//button[@data-state='closed']/span)[2]");
    }
}
