package hw4.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class HeaderMenu extends AbstractMenu {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement userProfileMenu;

    @FindBy(className = "logout")
    private SelenideElement logoutButton;

    public HeaderMenu() {
        page(this);
    }

    protected List<SelenideElement> getMenuItems() {
        return $$(By.cssSelector(".nav:nth-child(3) li"));
    }

    protected List<SelenideElement> getServiceDropdownItems() {
        return $$(By.xpath("//ul[@class='dropdown-menu']//li"));
    }

    public void clickUserMenuDropdown() {
        userProfileMenu.find(By.className("caret")).click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}
