package thucydides.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by dbaskal on 2/26/14.
 */
public class ResetPassword extends PageObject {

    @FindBy(className = "mw-htmlform-submit-buttons")
    private WebElement resetPasswordButton;

    public void isResetRswdBtn() {
        resetPasswordButton.isDisplayed();
    }

}
