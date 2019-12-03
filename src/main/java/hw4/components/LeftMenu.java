package hw4.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class LeftMenu extends AbstractMenu {

    public LeftMenu() {}

    protected List<SelenideElement> getMenuItems() {
        return $$(By.xpath("//ul[contains(@class, 'sidebar-menu')]//li"));
    }

    protected List<SelenideElement> getServiceDropdownItems() {
        return $$(By.xpath("//ul[@class='sub']//li"));
    }
}
