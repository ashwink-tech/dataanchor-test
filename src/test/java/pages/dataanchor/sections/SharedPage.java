package pages.dataanchor.sections;

import com.dataanchor.framework.exceptionhandling.DataAnchorCustomException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import static com.dataanchor.framework.config.Constants.*;
import static com.dataanchor.framework.controls.BrowserValidation.isDisplayed;

public class SharedPage extends BasePage<SharedPage> {

    private static MultiKeyMap<String, String> sharedPageMultiLocs = new MultiKeyMap<>();

    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, getLocators("Shared Page Name", TEXT))) {
            throw new DataAnchorCustomException("Shared Page was not successfully loaded");
        }
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return sharedPageMultiLocs.get(locator, elementType);
    }

    static {
        sharedPageMultiLocs.put("Shared Page Name", TEXT, "(//button[@data-state='closed']/h1)[2]");
        sharedPageMultiLocs.put("Actions", BUTTON, "//tr[@data-testid='table-row']//div[@data-state='closed']");
        sharedPageMultiLocs.put("Open in New Tab", LINK, "//div[@id='fp-sharedlink-table-body-0-0_actions-open']");
        sharedPageMultiLocs.put("Preview", LINK, "//div[@id='fp-sharedlink-table-body-0-0_actions-preview']");
    }
}
