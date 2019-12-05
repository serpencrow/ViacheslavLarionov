package hw5.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeftSideMenu extends AbstractMenu {

    private WebDriver driver;

    public LeftSideMenu(final WebDriver driver) {
        this.driver = driver;
    }

    protected List<WebElement> getMenuItems() {
        return driver.findElements(By.xpath("//ul[contains(@class, 'sidebar-menu')]//li"));
    }

    protected List<WebElement> getServiceDropdownItems() {
        return driver.findElements(By.xpath("//ul[@class='sub']//li"));
    }
}
