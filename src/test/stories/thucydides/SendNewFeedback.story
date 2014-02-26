package thucydides

import thucydides.steps.EndUserSteps
import thucydides.requirements.Application.Feedback.SendNewFeedback

using "thucydides"

thucydides.uses_default_base_url "http://en.wiktionary.org/wiki/Wiktionary:Main_Page"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SendNewFeedback

scenario "Cheking of possibility repeat submiting feedback", {
    given "the user is on the Wiktionary home page", {
        end_user.is_the_home_page()
    }
    when "the end user clicks one of the variants to submit feedback", {
        end_user.send_feedback_about_wictionary()
    }
    and "the end user refreshes page", {
        end_user.is_the_home_page()
    }
    then "he should see variants for feedback'", {
       end_user.are_variants_displayed()
    }
}
