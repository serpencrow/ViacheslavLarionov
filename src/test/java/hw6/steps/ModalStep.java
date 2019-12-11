package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.AbstractBaseStep;

public class ModalStep extends AbstractBaseStep {

    @Given("^I open EPAM JDI Site$")
    public void iOpenEpamJdiSite() {
        homePage.open();
    }

    @Given("^I am on Home Page$")
    public void iAmOnHomePage() {
        iOpenEpamJdiSite();
    }
}
