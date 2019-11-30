package hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(css = "#name")
    private WebElement userNameTextField;

    @FindBy(id = "password")
    private WebElement passwordNameTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement userNameLabel;

    public HomePage() {
        super();
    }

    public void login(final String username, final String password) {
        userIcon.click();
        userNameTextField.sendKeys(username);
        passwordNameTextField.sendKeys(password);
        loginButton.click();
    }

    public SelenideElement getUsernameLabel() {
        return userNameLabel;
    }
}
