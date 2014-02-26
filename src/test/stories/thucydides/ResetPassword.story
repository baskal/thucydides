package thucydides

import thucydides.steps.EndUserSteps
import thucydides.requirements.Application.Login.ResetPassword

using "thucydides"

thucydides.uses_default_base_url "http://en.wiktionary.org/wiki/Wiktionary:Main_Page"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story ResetPassword

scenario "Cheking of possibility to reset password", {
    given "the user is on the Wiktionary home page", {
        end_user.is_the_home_page()
    }
    when "the end user clicks the button 'Log in'", {
        end_user.go_to_login_page()
    }
    and "the end user clicks 'Forgot your password?'", {
        end_user.click_forgot_password()
    }
    then "he should see the page with button 'Reset password'", {
       end_user.is_reset_password_button_displayed()
    }
}
