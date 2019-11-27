package hw3;

import hw3.components.AbstractMenu;
import hw3.components.HeaderMenu;
import hw3.components.LeftSideMenu;
import hw3.enums.MenuSection;
import hw3.enums.MenuType;
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

    public boolean isAllMenuItemsInSectionDisplayed(final MenuType menuType,
                                                    final MenuSection menuSection) {
        return (menuType.equals(MenuType.HEADER_MENU))
                ? headerMenu.isAllMenuItemsDisplayed(menuSection)
                : leftSideMenu.isAllMenuItemsDisplayed(menuSection);
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
