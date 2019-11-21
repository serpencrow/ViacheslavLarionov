package hw2;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1Test extends AbstractBaseTest {

    @Test
    public void testSiteInterface() {
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

        // 5. Assert browser title again
        assertEquals(driver.getTitle(), "Home Page");

        // 6. Asset items on the header
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (int i = 0; i < expectedNames.size(); ++i) {
            WebElement element1 = driver.findElement(
                    By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li[" + (i + 1) + "]"));
            assertTrue(element1.isDisplayed());
            actualNames.add(element1.getText());
        }
        assertEquals(actualNames, expectedNames);

        // 7. Assert that there are 4 images on
        // the Index Page and they are displayed
        element = driver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']"));
        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']"));
        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']"));
        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("//span[@class='icons-benefit icon-base']"));
        assertTrue(element.isDisplayed());

        // 8. Assert that there are 4 images on
        // the Index Page and they are displayed
        List<String> expected = Arrays.asList(
                "To include good practices\n" +
                "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"
        );
        List<WebElement> elements = driver.findElements(By.className("benefit-txt"));
        List<String> actual = new ArrayList<>();
        elements.forEach(part -> {
            actual.add(part.getText());
        });
        for (WebElement elem : elements)
            assertTrue(elem.isDisplayed());
        assertEquals(actual, expected);

        // 9. Assert a text of the main headers
        List<String> expectedHeaders = Arrays.asList(
                "EPAM FRAMEWORK WISHES…",
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                        " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                        "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                        "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."
        );
        List<String> actualHeaders = Arrays.asList(
                driver.findElement(By.name("main-title")).getText(),
                driver.findElement(By.name("jdi-text")).getText()
        );
        assertEquals(actualHeaders, expectedHeaders);

        // 10. Assert that there is the iframe in the center of page
        element = driver.findElement(By.xpath("//iframe[@id='iframe']"));
        assertTrue(element.isDisplayed());

        // 11. Switch to the iframe and check that there
        // is Epam logo in the left top conner of iframe
        driver.switchTo().frame(driver.findElement(By.id("iframe")));
        element = driver.findElement(By.xpath("//img[@id='epam_logo']"));
        assertTrue(element.isDisplayed());

        // 12. Switch to original window back
        driver.switchTo().defaultContent();
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

        // 13. Assert a text of the sub header
        element = driver.findElement(By.xpath("//h3[@class='text-center']"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "JDI GITHUB");

        // 14. Assert that JDI GITHUB is a link and has a proper URL
        element = driver.findElement(By.linkText("JDI GITHUB"));
        assertEquals(element.getAttribute("href"), "https://github.com/epam/JDI");

        // 15. Assert that there is Left Section
        element = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(element.isDisplayed());

        // 16. Assert that there is Footer
        element = driver.findElement(By.className("footer-bg"));
        assertTrue(element.isDisplayed());

        // 17. Close Browser (in AbstractBaseTest class in tearDown() method)
    }
}
