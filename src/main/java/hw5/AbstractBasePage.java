package hw5;

import hw5.components.AbstractMenu;
import hw5.components.HeaderMenu;
import hw5.components.LeftSideMenu;
import hw5.enums.MenuSection;
import hw5.enums.MenuType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected AbstractMenu headerMenu;

    protected AbstractMenu leftSideMenu;

    @FindBy(className = "footer-bg")
    private WebElement footer;

    public AbstractBasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        headerMenu = new HeaderMenu(driver);
        leftSideMenu = new LeftSideMenu(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public int getHeaderItemsCount() {
        return headerMenu.getHeaderItemsCount();
    }

    public boolean areAllMenuItemsInSectionDisplayed(final MenuType menuType,
                                                     final MenuSection menuSection) {
        return (menuType.equals(MenuType.HEADER_MENU))
                ? headerMenu.areAllMenuItemsDisplayed(menuSection)
                : leftSideMenu.areAllMenuItemsDisplayed(menuSection);
    }

    public void clickOnItemInMenuSection(final MenuType menuType, final MenuSection menuSection,
                                         final String itemName) {
        switch (menuType) {
            case HEADER_MENU:
                headerMenu.menuItemClick(menuSection, itemName);
                break;

            case LEFT_SIDE_MENU:
                leftSideMenu.menuItemClick(menuSection, itemName);
                break;
        }
    }

    public boolean isItemContainsInMenuSection(final MenuType menuType, final MenuSection menuSection,
                                               final String itemName) {
        return (menuType.equals(MenuType.HEADER_MENU))
                ? headerMenu.isMenuContainsItem(menuSection, itemName)
                : leftSideMenu.isMenuContainsItem(menuSection, itemName);
    }

    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }
}
