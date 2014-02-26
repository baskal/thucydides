package thucydides.requirements;

import net.thucydides.core.annotations.Feature;

public class Application {
    @Feature
    public class Search {
        public class SearchByKeyword {}
        public class SearchABlank {}
        public class SearchByMultipleKeywords {}
    }

    @Feature
    public class Login {
        public class LoginElements {}
        public class ResetPassword {}
    }

    @Feature
    public class Feedback {
        public class SendFeedback {}
        public class SendNewFeedback {}
    }
}