package hw4;

import com.codeborne.selenide.WebDriverRunner;
import hw4.components.enums.MenuSection;
import hw4.components.enums.MenuType;
import hw4.ex1.enums.ServiceSubcategories;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseSteps {

    protected HomePage homePage;

    public BaseSteps() {
        homePage = new HomePage();
    }

    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

    public void usernameOnTheHomePageShouldBeDisplayed() {
        homePage.getUsernameLabel().shouldBe(visible);
    }

    public void usernameOnTheHomePageShouldBe(final String username) {
        homePage.getUsernameLabel().shouldBe(text(username));
    }

    public void titleShouldBe(final String titleName) {
        assertEquals(homePage.getTitle(), titleName);
    }

    public void headerMenuItemClick(final String itemName) {
        homePage.menuItemClick(MenuType.HEADER_MENU, MenuSection.MAIN_SECTION, itemName);
    }

    public void leftMenuItemClick(final String itemName) {
        homePage.menuItemClick(MenuType.LEFT_MENU, MenuSection.MAIN_SECTION, itemName);
    }

    public void headerServiceDropdownMenuItemClick(final ServiceSubcategories subcategory) {
        homePage.menuItemClick(MenuType.HEADER_MENU, MenuSection.SERVICE_SECTION,
                subcategory.getCategoryName());
    }

    public void headerServiceDropdownShouldContainItem(final ServiceSubcategories subcategory) {
        assertTrue(homePage.isItemContainsInMenuSection(MenuType.HEADER_MENU,
                MenuSection.SERVICE_SECTION, subcategory.getCategoryName()));
    }

    public void leftServiceDropdownShouldContainItem(final ServiceSubcategories subcategory) {
        assertTrue(homePage.isItemContainsInMenuSection(MenuType.LEFT_MENU,
                MenuSection.SERVICE_SECTION, subcategory.getCategoryName()));
    }

    public void currentUrlShouldBe(final String currentUrl) {
        assertEquals(WebDriverRunner.url(), currentUrl);
    }
}
