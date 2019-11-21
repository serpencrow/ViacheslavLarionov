package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2Test extends AbstractBaseTest {

    private SoftAssert softAssert;

    @Test
    public void testSiteInterface() {
        // Soft Assert initialization
        softAssert = new SoftAssert();

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Asset User name
        WebElement element = driver.findElement(By.xpath("//span[@id='user-name']"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");

        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        List<String> expectedNames = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Table with pages",
                "Different elements");
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        WebElement element1 = driver.findElement(By.className("dropdown-menu"));

        expectedNames.forEach(expectedName -> {
            WebElement elem = element1.findElement(By.linkText(expectedName.toUpperCase()));
            softAssert.assertTrue(elem.isDisplayed());
        });
        softAssert.assertAll();

        // 6. Click on Service subcategory in the left
        // section and check that drop down contains options
        driver.findElement(By.xpath("//*[contains(@class, 'fa fa-caret-down arrow')]")).click();
        WebElement element2 = driver.findElement(By.className("sub"));
        expectedNames.forEach(expectedName -> {
            WebElement elem = element2.findElement(By.linkText(expectedName));
            softAssert.assertTrue(elem.isDisplayed());
        });
        softAssert.assertAll();

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.xpath("//li[@class='dropdown']")).click();
        element = driver.findElement(By.className("dropdown-menu"));
        element.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/different-elements.html");

        // 8. Check interface on Different elements
        // page, it contains all needed elements
        int checkboxCount = driver.findElements(By.className("label-checkbox")).size();
        softAssert.assertEquals(checkboxCount, 4);
        int radioCount = driver.findElements(By.className("label-radio")).size();
        softAssert.assertEquals(radioCount, 4);
        WebElement dropdown = driver.findElement(By.className("colors"));
        softAssert.assertTrue(dropdown.isDisplayed());
        WebElement button = driver.findElement(By.xpath("//button[@name='Default Button']"));
        softAssert.assertTrue(button.isDisplayed());
        button = driver.findElement(By.xpath("//input[@class='uui-button']"));
        softAssert.assertTrue(button.isDisplayed());
        softAssert.assertAll();

        // 9. Assert that there is Right Section
        element = driver.findElement(By.className("sidebar-menu"));
        assertTrue(element.isDisplayed());

        // 10. Assert that there is Left Section
        element = driver.findElement(By.name("log-sidebar"));
        assertTrue(element.isDisplayed());

        // Checkbox names for future tests
        List<String> checkboxNames = Arrays.asList("Water", "Wind");

        // 11. Select checkboxes: Water, Wind
        driver.findElements(By.className("label-checkbox")).forEach( elem -> {
            if (elem.getText().equals(checkboxNames.get(0)) || elem.getText().equals(checkboxNames.get(1))) {
                WebElement box = elem.findElement(By.tagName("input"));
                box.click();
                softAssert.assertTrue(box.isSelected());
            }
        });
        softAssert.assertAll();

        // 12. Assert that for each checkbox there is
        // an individual log row and value
        // is corresponded to the status of checkbox.

        // Fist, get checkbox states
        // state.get(0) - Water checkbox state
        // state.get(1) - Wind checkbox state
        // (we know that they are selected,
        // just try to get this information
        // from checkboxes directly)
        List<String> states = new ArrayList<>();
        driver.findElements(By.className("label-checkbox")).forEach( elem -> {
            WebElement checkbox = elem.findElement(By.tagName("input"));
            if (elem.getText().contains(checkboxNames.get(0))
                    || elem.getText().contains(checkboxNames.get(1))) {
                states.add(checkbox.isSelected() ? "true" : "false");
            }
        });

        // Second, from information in logs
        // check that all two checkboxes
        // have right states
        WebElement log = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']"));
        for (WebElement elem : log.findElements(By.tagName("li"))) {
            boolean isWaterCheckbox = elem.getText().contains(checkboxNames.get(0));
            boolean isWindCheckbox = elem.getText().contains(checkboxNames.get(1));

            if (isWaterCheckbox || isWindCheckbox) {
                softAssert.assertTrue(elem.getText().contains(states.get(isWaterCheckbox ? 0 : 1)));
            }
        }
        softAssert.assertAll();

        // 13. Select radio "Selen"
        String radioName = "Selen";
        driver.findElements(By.className("label-radio")).forEach(elem -> {
            if (elem.getText().equals(radioName)) {
                WebElement radio = elem.findElement(By.tagName("input"));
                radio.click();
                assertTrue(radio.isSelected());
            }
        });

        // 14. Assert that for radiobutton there is
        // a log row and value is corresponded to
        // the status of radiobutton
        boolean isRadioInLog = false;
        //log = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']"));
        for (WebElement elem : log.findElements(By.tagName("li"))) {
            if (elem.getText().contains(radioName)) {
                assertTrue(elem.isDisplayed());
                isRadioInLog = true;
                break;
            }
        }
        assertTrue(isRadioInLog);

        // 15. Assert that for dropdown there is
        // a log row and value is corresponded
        // to the selected value.
        String selectedValue = "Yellow";
        // open dropdown
        dropdown.click();
        Select select = new Select(driver.findElement(By.xpath("//select[@class='uui-form-element']")));
        select.selectByVisibleText(selectedValue);
        // close dropdown
        dropdown.click();
        assertEquals(select.getFirstSelectedOption().getText(), selectedValue);

        // 16. Assert that for dropdown there
        // is a log row and value is corresponded
        // to the selected value.
        boolean isSelectInLog = false;
        for (WebElement elem : log.findElements(By.tagName("li"))) {
            if (elem.getText().contains(selectedValue)) {
                isSelectInLog = true;
                break;
            }
        }
        assertTrue(isSelectInLog);

        // 17. Unselect and assert checkboxes (Water, Wind)
        driver.findElements(By.className("label-checkbox")).forEach(elem -> {
            if (elem.getText().contains(checkboxNames.get(0)) ||
                    elem.getText().contains(checkboxNames.get(1))) {
                elem.click();
                softAssert.assertTrue(!elem.isSelected());
            }
        });
        softAssert.assertAll();

        // 18. Assert that for each checkbox
        // there is an individual log row and
        // value is corresponded to the status of checkbox.
        boolean isFirstWaterLog = true;
        boolean isFirstWindLog = true;
        for (WebElement elem : log.findElements(By.tagName("li"))) {
            boolean isWaterCheckbox = elem.getText().contains(checkboxNames.get(0));
            boolean isWindCheckbox = elem.getText().contains(checkboxNames.get(1));

            if ((isWaterCheckbox && isFirstWaterLog) || (isWindCheckbox && isFirstWindLog)) {
                // "false" - state of checkboxes what they are unselected
                softAssert.assertTrue(elem.getText().contains("false"));
                if (isWaterCheckbox)
                    isFirstWaterLog = false;
                else
                    isFirstWindLog = false;

                if (!isFirstWaterLog && !isFirstWindLog)
                    break;
            }
        }
        softAssert.assertAll();
    }
}
