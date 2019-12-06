package hw5.steps;

import hw5.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseSteps {

    protected HomePage homePage;

    public BaseSteps(final WebDriver driver) {
        homePage = new HomePage(driver);
    }

    @Step("I open EPAM JDI Site")
    public void openEpamJdiSite() {
        homePage.open();
    }

    @Step("I login as '{0}' with password '{1}'")
    public void login(final String username, final String password) {
        homePage.clickUserIcon();
        homePage.fillUsernameTextField(username);
        homePage.fillPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @Step("Username on HomePage should be displayed")
    public void usernameOnTheHomePageShouldBeDisplayed() {
        assertTrue(homePage.usernameLabelIsDisplayed());
    }

    @Step("Username on HomePage should be {0}")
    public void usernameOnTheHomePageShouldBe(final String username) {
        assertEquals(homePage.getUsernameLabelText(), username);
    }
}
