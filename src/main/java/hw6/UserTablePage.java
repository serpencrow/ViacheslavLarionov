package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends AbstractBasePage {

    public UserTablePage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td select")
    private List<WebElement> dropdowns;

    @FindBy(css = "td a")
    private List<WebElement> usernames;

    @FindBy(css = "td img")
    private List<WebElement> descriptionImages;

    @FindBy(css = ".user-descr span")
    private List<WebElement> descriptions;

    @FindBy(css = ".user-descr input")
    private List<WebElement> checkboxes;

    @FindBy(css = "td:nth-child(1)")
    private List<WebElement> numbers;

    @FindBy(css = ".logs li")
    private List<WebElement> logRows;

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<WebElement> getDescriptionImages() {
        return descriptionImages;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getNumbers() {
        return numbers;
    }

    private int getUsernameIndexByUsername(final String username) {
        return Utils.getWebElementTexts(usernames).indexOf(username);
    }

    public void clickOnVipCheckboxFor(final String username) {
       int userIndex = getUsernameIndexByUsername(username);
       if (userIndex >=0)
           checkboxes.get(userIndex).click();
    }

    public boolean isFirstLogContains(final String logText) {
        return logRows.get(0).getText().contains(logText);
    }

    public void clickOnDropdownForUser(final String username) {
        int userIndex = getUsernameIndexByUsername(username);
        if (userIndex >= 0)
            dropdowns.get(userIndex).click();
    }

    public List<WebElement> getDroplistByUsername(final String username) {
        int userIndex = getUsernameIndexByUsername(username);
        if (userIndex >= 0) {
            return dropdowns.get(userIndex).findElements(By.tagName("option"));
        } else {
            return null;
        }
    }
}
