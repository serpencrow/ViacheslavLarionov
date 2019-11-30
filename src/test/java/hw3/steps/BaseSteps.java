package hw3.steps;

import hw3.HomePage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseSteps {

    protected HomePage homePage;

    public BaseSteps(final WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void openEpamJdiSite() {
        homePage.open();
    }

    public void login(final String username, final String password) {
        homePage.clickUserIcon();
        homePage.fillUsernameTextField(username);
        homePage.fillPasswordTextField(password);
        homePage.clickLoginButton();
    }

    public void usernameOnTheHomePageShouldBeDisplayed() {
        assertTrue(homePage.usernameLabelIsDisplayed());
    }

    public void usernameOnTheHomePageShouldBe(final String username) {
        assertEquals(homePage.getUsernameLabelText(), username);
    }
}
