package hw3;

import hw3.enums.ButtonType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractBasePage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;

    @FindBy(className = "colors")
    private WebElement dropdownColorMenu;

    @FindBy(name = "Default Button")
    private WebElement defaultButton;

    @FindBy(xpath = "//input[@class='uui-button']")
    private WebElement button;

    @FindBy(className = "sidebar-menu")
    private WebElement leftSection;

    @FindBy(name = "log-sidebar")
    private WebElement rightSection;

    @FindBy(css = ".info-panel-section .logs")
    private WebElement logSection;

    private Select colorSelectorTextField;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public int getCheckboxCount() {
        return checkboxes.size();
    }

    public int getRadioButtonsCount() {
        return radioButtons.size();
    }

    public boolean isButtonTypeDisplayed(final ButtonType buttonType, final String buttonName) {
        List<WebElement> buttons = (buttonType.equals(ButtonType.CHECKBOX))
                ? checkboxes
                : radioButtons;

        for (WebElement button : buttons) {
            if (buttonName
                    .equalsIgnoreCase(button.getText())) {
                return button.isDisplayed();
            }
        }
        return false;
    }

    public boolean dropdownColorsIsDisplayed() {
        return dropdownColorMenu.isDisplayed();
    }

    public boolean defaultButtonIsDisplayed() {
        return defaultButton.isDisplayed();
    }

    public boolean buttonIsDisplayed() {
        return button.isDisplayed();
    }

    public boolean leftSectionIsDisplayed() {
        return leftSection.isDisplayed();
    }

    public boolean rightSectionIsDisplayed() {
        return rightSection.isDisplayed();
    }

    public void selectButton(final ButtonType buttonType, final String buttonName) {
        List<WebElement> buttons = (buttonType.equals(ButtonType.CHECKBOX))
                ? checkboxes
                : radioButtons;

        for (WebElement button : buttons) {
            if (buttonName
                    .equalsIgnoreCase(button.getText())) {
                button.click();
                break;
            }
        }
    }

    public boolean checkboxIsSelected(final String checkboxName) {
        for (int i = 0; i < checkboxes.size(); ++i) {
            if (checkboxName
                    .equalsIgnoreCase(checkboxes.get(i).getText())) {
                return checkboxes.get(i)
                        .findElement(By.cssSelector(":nth-child(" + (i + 1) + ") input"))
                        .isSelected();
            }
        }
        return false;
    }

    public boolean radioButtonIsSelected(final String radioButtonName) {
        for (int i = 0; i < radioButtons.size(); ++i) {
            if (radioButtonName
                    .equalsIgnoreCase(radioButtons.get(i).getText())) {
                return radioButtons.get(i)
                        .findElement(By.cssSelector(":nth-child(" + (i + 1) + ") input"))
                        .isSelected();
            }
        }
        return false;
    }

    public boolean firstLogRowContains(final String logRow) {
        return logSection.findElements(By.tagName("li")).get(0).getText().contains(logRow);
    }

    public void clickOnDropdownMenu() {
        dropdownColorMenu.click();
    }

    public void selectDropdownColor(final String colorName) {
        if (colorSelectorTextField == null) {
            colorSelectorTextField = new Select(driver.findElement(By
                    .xpath("//select[@class='uui-form-element']")));
        }
        colorSelectorTextField.selectByVisibleText(colorName);
    }

    public String getSelectedColor() {
        return colorSelectorTextField.getFirstSelectedOption().getText();
    }
}
