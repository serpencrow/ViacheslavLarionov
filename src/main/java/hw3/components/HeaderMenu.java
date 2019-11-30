package hw3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderMenu extends AbstractMenu {

    private WebDriver driver;

    public HeaderMenu(final WebDriver driver) {
        this.driver = driver;
    }

    protected List<WebElement> getMenuItems() {
        return driver.findElements(By.cssSelector(".nav:nth-child(3) li"));
    }

    protected List<WebElement> getServiceDropdownItems() {
        return driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li"));
    }
}
