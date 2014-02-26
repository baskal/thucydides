package thucydides.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;

/**
 * Created by dbaskal on 2/26/14.
 */

@DefaultUrl("http://en.wiktionary.org/wiki/Special:Search?search=&go=Look+up")
public class SpecialPage extends PageObject {

    @FindBy(id = "searchText")
    private WebElement searchTextField;

    public SpecialPage(WebDriver driver) {
        super(driver);
    }

    public void is_text_field_displayed() {
        searchTextField.isDisplayed();
    }

}
