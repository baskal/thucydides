package thucydides.steps;

import jnr.ffi.types.sa_family_t;
import thucydides.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import thucydides.pages.LoginPage;
import thucydides.pages.ResetPassword;
import thucydides.pages.SpecialPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;
    SpecialPage specialPage;
    LoginPage loginPage;
    ResetPassword resetPassword;

    public EndUserSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        boolean isContains = false;
        for (String line: dictionaryPage.getDefinitions()) {
            System.out.println(line);
            System.out.println(line.equals(definition));

            if (line.startsWith(definition)) {
                isContains = true;
                break;
            }

        }
        assertTrue(isContains);
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void click_in_the_search_field() {
        dictionaryPage.click_in_the_search_field();
    }

    @Step
    public void assert_elements() {
        specialPage.is_text_field_displayed();
        assertFalse(specialPage.containsText("There is a page named"));
        assertFalse(specialPage.containsText("There were no results"));
    }

    @Step
    public void go_to_login_page() {
        dictionaryPage.go_to_login();
    }

    @Step
    public void assert_elements_for_login() {
        loginPage.assert_elements_for_login();
    }

    @Step
    public void send_feedback_about_wictionary() {
        dictionaryPage.send_feedback();
    }

    @Step
    public void assert_thanks_for_feedback() {
        dictionaryPage.containsText("Thank you for giving us some of your time.");
    }

    @Step
    public void are_variants_displayed() {
        dictionaryPage.are_variants_displayed();
    }

    @Step
    public void click_forgot_password() {
        loginPage.forgot_password();
    }

    @Step
    public void is_reset_password_button_displayed() {
        resetPassword.isResetRswdBtn();
    }

}