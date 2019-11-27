package hw2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Arrays;
import java.util.List;

public class Exercise2Test extends AbstractBaseTest {

    private SoftAssert softAssert;

    @Test
    public void testSiteInterface() {
        // Soft Assert initialization
        softAssert = new SoftAssert();

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Asset User name
        WebElement userNameLabel = driver.findElement(By.xpath("//span[@id='user-name']"));
        softAssert.assertTrue(userNameLabel.isDisplayed());
        softAssert.assertEquals(userNameLabel.getText(), "PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        List<String> expectedNames = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Table with pages",
                "Different elements");
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        WebElement headerServiceDropdownMenu = driver.findElement(By.className("dropdown-menu"));

        expectedNames.forEach(expectedName -> {
            WebElement headerItem = headerServiceDropdownMenu
                    .findElement(By.linkText(expectedName.toUpperCase()));
            softAssert.assertTrue(headerItem.isDisplayed());
        });

        // 6. Click on Service subcategory in the left
        // section and check that drop down contains options
        driver.findElement(By.xpath("//div[contains(@class, 'fa-caret-down')]")).click();
        WebElement subcategoryMenu = driver.findElement(By.className("sub"));
        expectedNames.forEach(expectedName -> {
            WebElement subcategoryItem = subcategoryMenu.findElement(By.linkText(expectedName));
            softAssert.assertTrue(subcategoryItem.isDisplayed());
        });

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        headerServiceDropdownMenu.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://epam.github.io/JDI/different-elements.html");

        // 8. Check interface on Different elements
        // page, it contains all needed elements
        int checkboxCount = driver.findElements(By.className("label-checkbox")).size();
        softAssert.assertEquals(checkboxCount, 4);
        int radioCount = driver.findElements(By.className("label-radio")).size();
        softAssert.assertEquals(radioCount, 4);
        WebElement dropdownColorsMenu = driver.findElement(By.className("colors"));
        softAssert.assertTrue(dropdownColorsMenu.isDisplayed());
        WebElement firstFormButton = driver.findElement(By.xpath("//button[@name='Default Button']"));
        softAssert.assertTrue(firstFormButton.isDisplayed());
        WebElement secondFormButton = driver.findElement(By.xpath("//input[@class='uui-button']"));
        softAssert.assertTrue(secondFormButton.isDisplayed());

        // 9. Assert that there is Right Section
        WebElement rightSectionMenu = driver.findElement(By.className("sidebar-menu"));
        softAssert.assertTrue(rightSectionMenu.isDisplayed());

        // 10. Assert that there is Left Section
        WebElement logSidebar = driver.findElement(By.name("log-sidebar"));
        softAssert.assertTrue(logSidebar.isDisplayed());

        // Checkbox names for future tests
        List<String> checkboxNames = Arrays.asList("Water", "Wind");

        // 11. Select checkboxes: Water, Wind
        WebElement waterCheckBox = driver.findElement(By.cssSelector(".label-checkbox:nth-of-type(1) input"));
        WebElement windCheckBox = driver.findElement(By.cssSelector(".label-checkbox:nth-of-type(3) input"));
        waterCheckBox.click();
        windCheckBox.click();
        softAssert.assertTrue(waterCheckBox.isSelected());
        softAssert.assertTrue(windCheckBox.isSelected());

        // Log list element for future tests
        List<WebElement> logList = driver.findElements(By.cssSelector(".info-panel-section .logs li"));

        // 12. Assert that for each checkbox there is
        // an individual log row and value
        // is corresponded to the status of checkbox.
        softAssert.assertTrue(logList.get(0).isDisplayed());
        softAssert.assertTrue(logList.get(0).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logList.get(1).isDisplayed());
        softAssert.assertTrue(logList.get(1).getText().contains("Water: condition changed to true"));

        // 13. Select radio "Selen"
        String radioName = "Selen";
        WebElement selenRadioButton = driver.findElement(By.cssSelector(".label-radio:nth-of-type(4) input"));
        selenRadioButton.click();
        softAssert.assertTrue(selenRadioButton.isSelected());

        // 14. Assert that for radiobutton there is
        // a log row and value is corresponded to
        // the status of radiobutton
        logList = driver.findElements(By.cssSelector(".info-panel-section .logs li"));
        softAssert.assertTrue(logList.get(0).isDisplayed());
        softAssert.assertTrue(logList.get(0).getText().contains(radioName));

        // 15. Assert that for dropdown there is
        // a log row and value is corresponded
        // to the selected value.
        String selectedValue = "Yellow";
        dropdownColorsMenu.click();
        Select dropdownSelector = new Select(driver
                .findElement(By.xpath("//select[@class='uui-form-element']")));
        dropdownSelector.selectByVisibleText(selectedValue);
        dropdownColorsMenu.click();
        softAssert.assertEquals(dropdownSelector.getFirstSelectedOption().getText(), selectedValue);

        // 16. Assert that for dropdown there
        // is a log row and value is corresponded
        // to the selected value.
        logList = driver.findElements(By.cssSelector(".info-panel-section .logs li"));
        softAssert.assertTrue(logList.get(0).isDisplayed());
        softAssert.assertTrue(logList.get(0).getText().contains(selectedValue));

        // 17. Unselect and assert checkboxes (Water, Wind)
        waterCheckBox.click();
        softAssert.assertTrue(!waterCheckBox.isSelected());
        windCheckBox.click();
        softAssert.assertTrue(!windCheckBox.isSelected());

        // 18. Assert that for each checkbox
        // there is an individual log row and
        // value is corresponded to the status of checkbox.
        logList = driver.findElements(By.cssSelector(".info-panel-section .logs li"));
        softAssert.assertTrue(logList.get(0).isDisplayed());
        softAssert.assertTrue(logList.get(0).getText().contains("Wind: condition changed to false"));
        softAssert.assertTrue(logList.get(1).isDisplayed());
        softAssert.assertTrue(logList.get(1).getText().contains("Water: condition changed to false"));

        softAssert.assertAll();
    }
}
