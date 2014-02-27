package thucydides

import thucydides.steps.EndUserSteps
import thucydides.requirements.Application.Feedback.SendFeedback

using "thucydides"

thucydides.uses_default_base_url "http://en.wiktionary.org/wiki/Wiktionary:Main_Page"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SendFeedback

scenario "Cheking of submiting feedback", {
    given "the user is on the Wiktionary home page", {
        end_user.is_the_home_page()
    }
    when "the end user click one of the variants to submit feedback", {
        end_user.send_feedback_about_wictionary()
    }
    then "he should see 'Thank you for giving us some of your time.'", {
       end_user.assert_thanks_for_feedback("Thank you for giving us some of your time.")
    }
}
