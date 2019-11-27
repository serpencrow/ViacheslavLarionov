package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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
    private WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(@class, 'icons-benefit')]")
    private List<WebElement> images;

    @FindBy(xpath = "//span[contains(@class, 'benefit-txt')]")
    private List<WebElement> imageTexts;

    @FindBy(name = "main-title")
    private WebElement firstMainHeader;

    @FindBy(name = "jdi-text")
    private WebElement secondMainHeader;

    @FindBy(id = "iframe")
    private WebElement iframe;

    @FindBy(xpath = "//h3[@class='text-center']")
    private WebElement subheaderTextField;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement subHeaderLinkText;

    @FindBy(name = "navigation-sidebar")
    private WebElement lefSection;

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(Constants.HOME_URL);
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void fillUsernameTextField(final String username) {
        userNameTextField.sendKeys(username);
    }

    public void fillPasswordTextField(final String password) {
        passwordNameTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUsernameLabelDisplayed() {
        return userNameLabel.isDisplayed();
    }

    public String getUsernameLabelText() {
        return userNameLabel.getText();
    }

    public boolean isFirstHeaderDisplayed() {
        return firstMainHeader.isDisplayed();
    }

    public boolean isSecondHeaderDisplayed() {
        return secondMainHeader.isDisplayed();
    }

    public String getFirstHeaderText() {
        return firstMainHeader.getText();
    }

    public String getSecondHeaderText() {
        return secondMainHeader.getText();
    }

    public int getImagesCount() {
        return images.size();
    }

    public boolean isAllImagesDisplayed() {
        boolean isDisplayed = true;

        for (WebElement image : images) {
            isDisplayed &= image.isDisplayed();
        }
        return isDisplayed;
    }

    public int getImageTextsCount() {
        return imageTexts.size();
    }

    public boolean isAllTextsUnderImagesDisplayed() {
        boolean isDisplayed = true;
        for (WebElement imageText : imageTexts) {
            isDisplayed &= imageText.isDisplayed();
        }
        return isDisplayed;
    }

    public List<String> getTextsUnderImages() {
        List<String> textUnderImages = new ArrayList<>();
        for (WebElement benefitIconText : imageTexts) {
            textUnderImages.add(benefitIconText.getText());
        }
        return textUnderImages;
    }

    public boolean isIframeDisplayed() {
        return iframe.isDisplayed();
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public boolean iframeHaveEpamLogo() {
        return iframe.isDisplayed();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public boolean isSubheaderDisplayed() {
        return subheaderTextField.isDisplayed();
    }

    public String getSubheaderFieldText() {
        return subheaderTextField.getText();
    }

    public String getSubheaderLinkText() {
        return subHeaderLinkText.getAttribute("href");
    }

    public boolean isLeftSectionDisplayed() {
        return lefSection.isDisplayed();
    }
}
