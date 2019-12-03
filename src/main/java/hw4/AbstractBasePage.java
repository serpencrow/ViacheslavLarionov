package hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.components.AbstractMenu;
import hw4.components.HeaderMenu;
import hw4.components.LeftMenu;
import hw4.components.enums.MenuSection;
import hw4.components.enums.MenuType;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public abstract class AbstractBasePage {

    protected AbstractMenu headerMenu;

    protected AbstractMenu leftMenu;

    @FindBy(name = "navigation-sidebar")
    private SelenideElement leftSection;

    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;

    public AbstractBasePage() {
        page(this);
        headerMenu = new HeaderMenu();
        leftMenu = new LeftMenu();
    }

    public String getTitle() {
        return Selenide.title();
    }

    public void menuItemClick(final MenuType menuType, final MenuSection menuSection,
                                         final String itemName) {
        switch (menuType) {
            case HEADER_MENU:
                headerMenu.menuItemClick(menuSection, itemName);
                break;

            case LEFT_MENU:
                leftMenu.menuItemClick(menuSection, itemName);
                break;
        }
    }

    public boolean isItemContainsInMenuSection(final MenuType menuType, final MenuSection menuSection,
                                               final String itemName) {
        return (menuType.equals(MenuType.HEADER_MENU))
                ? headerMenu.isMenuContainsItem(menuSection, itemName)
                : leftMenu.isMenuContainsItem(menuSection, itemName);
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public void clickUserMenuDropdown() {
        ((HeaderMenu) headerMenu).clickUserMenuDropdown();
    }

    public void clickLogoutButton() {
        ((HeaderMenu) headerMenu).clickLogoutButton();
    }
}
