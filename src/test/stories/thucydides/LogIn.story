package thucydides

import thucydides.steps.EndUserSteps
import thucydides.requirements.Application.Login.LoginElements

using "thucydides"

thucydides.uses_default_base_url "http://en.wiktionary.org/wiki/Wiktionary:Main_Page"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story LoginElements

scenario "Cheking of elements for login", {
    given "the user is on the Wiktionary home page", {
        end_user.is_the_home_page()
    }
    when "the end user clicks the button 'Log in'", {
        end_user.go_to_login_page()
    }
    then "he should see the page with field 'username', 'password' and button 'Log in'", {
       end_user.assert_elements_for_login()
    }
}
