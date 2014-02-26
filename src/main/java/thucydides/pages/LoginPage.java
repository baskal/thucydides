package thucydides.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by dbaskal on 2/26/14.
 */

@DefaultUrl("https://en.wiktionary.org/w/index.php?title=Special:UserLogin&returnto=Wiktionary%3AMain+Page")
public class LoginPage extends PageObject {

    @FindBy(name = "wpName")
    private WebElement usernameTextBox;

    @FindBy(name = "wpPassword")
    private WebElement passwordTextBox;

    @FindBy(name = "wpLoginAttempt")
    private WebElement submitButton;

    @FindBy(className = "mw-ui-flush-right")
    private WebElement forgotPassword;

    public void assert_elements_for_login() {
        usernameTextBox.isDisplayed();
        passwordTextBox.isDisplayed();
        submitButton.isDisplayed();
    }

    public void forgot_password() {
        forgotPassword.click();
    }

}
