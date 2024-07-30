package pages.dataanchor.files;

import com.dataanchor.framework.exceptionhandling.DataAnchorCustomException;
import org.apache.commons.collections4.map.MultiKeyMap;
import pages.BasePage;

import static com.dataanchor.framework.config.Constants.*;
import static com.dataanchor.framework.controls.BrowserValidation.isDisplayed;

public class Books extends BasePage<Books> {

    private static MultiKeyMap<String, String> booksMultiLocs = new MultiKeyMap<>();


    @Override
    protected void isLoaded() {
        if (!isDisplayed(driver, getLocators("Book", "Form"))) {
            throw new DataAnchorCustomException("Book Page was not successfully loaded");
        }
    }

    @Override
    public String getLocators(String locator, String elementType) {
        return booksMultiLocs.get(locator, elementType);
    }

    static {
        booksMultiLocs.put("Book", "Form", "//form[@id='office_form']");
        booksMultiLocs.put("Book", "Frame", "//iframe[@id='office_frame']");
        booksMultiLocs.put("Mode", TEXT, "(//button[@id='ModeSwitcher']//span)[2]");
    }
}
