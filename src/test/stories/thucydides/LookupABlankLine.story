package thucydides

import thucydides.steps.EndUserSteps
import thucydides.requirements.Application.Search.SearchABlank

using "thucydides"

thucydides.uses_default_base_url "http://en.wiktionary.org/wiki/Wiktionary:Main_Page"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchABlank

scenario "Looking up a blank line", {
    given "the user is on the Wiktionary home page", {
        end_user.is_the_home_page()
    }
    when "the end user looks up a blank line", {
        end_user.looks_for("");
    }
    then "he should see the special page with field 'search'", {
       end_user.assert_elements()
    }
}
