package hw6.steps;

import cucumber.api.java.en.When;
import hw6.AbstractBaseStep;
import hw6.Constants;
import hw6.UserInfo;
import hw6.Utils;
import hw6.enums.ButtonType;
import hw6.enums.MenuType;

import java.util.Objects;

import static hw6.enums.MenuSection.MAIN_SECTION;
import static hw6.enums.MenuSection.SERVICE_SECTION;
import static hw6.enums.MenuType.HEADER_MENU;
import static hw6.enums.MenuType.LEFT_MENU;

public class ActionStep extends AbstractBaseStep {

    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on Home Page$")
    public void iLoginAsUserWithPasswordOnTheHomePage(final String username,
                                                      final String password) {
        homePage.clickUserIcon();
        homePage.fillUsernameTextField(username);
        homePage.fillPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @When("^I click in '(header|left)' menu on item '([^\"]+)' on Home Page$")
    public void iClickInMenuOnItemOnTheHomePage(final String menuName,
                                                final String itemName) {
        MenuType menuType = null;
        switch (menuName) {
            case "header":
                menuType = HEADER_MENU;
                break;

            case "left":
                menuType = LEFT_MENU;
                break;
        }
        homePage.clickOnItemInMenuSection(Objects.requireNonNull(menuType), MAIN_SECTION, itemName);
    }

    @When("^I click on item '([^\"]+)' in service subcategories in '(header|left)' menu on Home Page$")
    public void iClickOnItemInServiceSubcategoriesInHeaderMenu(final String itemName,
                                                               final String menuName) {
        MenuType menuType = null;
        switch (menuName) {
            case "header":
                menuType = HEADER_MENU;
                break;

            case "left":
                menuType = LEFT_MENU;
                break;
        }
        homePage.clickOnItemInMenuSection(Objects.requireNonNull(menuType), SERVICE_SECTION, itemName);
    }

    @When("^I click on '(checkbox|radiobutton)' with name '([^\"]+)' on Different Elements Page$")
    public void clickOnButtonType(final String buttonTypeName, final String buttonName) {
        ButtonType buttonType = null;
        switch (buttonTypeName) {
            case "checkbox":
                buttonType = ButtonType.CHECKBOX;
                break;

            case "radiobutton":
                buttonType = ButtonType.RADIOBUTTON;
                break;
        }
        differentElementsPage.selectButton(buttonType, buttonName);
    }

    @When("^I click on dropdown colors on Different Elements Page$")
    public void iClickOnDropdown() {
        differentElementsPage.clickOnDropdownMenu();
    }

    @When("^I choose '(Red|Green|Blue|Yellow)' color in the dropdown$")
    public void iChooseColorInTheDropdown(final String dropdownColor) {
        differentElementsPage.selectDropdownColor(dropdownColor);
    }

    @When("^I login as user '([^\"]+)'$")
    public void iLoginAsUser(final String username) {
        UserInfo userInfo = Utils
                .getUserInfoFromPropertyFile(Constants.PATH_TO_PROPERTIES, username);
        iLoginAsUserWithPasswordOnTheHomePage(userInfo.getUsername(),
                userInfo.getPassword());
    }

    @When("^I click on '([^\"]+)' button in Header on Home Page$")
    public void iClickOnButtonInHeader(final String buttonName) {
        iClickInMenuOnItemOnTheHomePage("header", buttonName);
    }

    @When("^I click on '([^\"]+)' button in Service dropdown on Home Page$")
    public void iClickOnButtonInHeaderServiceDropdown(final String buttonName) {
        iClickOnItemInServiceSubcategoriesInHeaderMenu(buttonName, "header");
    }

    @When("^I select 'vip' checkbox for '([^\"]+)' on Users Table on User Table Page$")
    public void iSelectVipCheckboxFor(final String username) {
        userTablePage.clickOnVipCheckboxFor(username);
    }

    @When("^I click on dropdown in column Type for user '([^\"]+)' on Users Table on User Table Page$")
    public void iClickOnDropdownInColumnTypeForUser(final String username) {
        userTablePage.clickOnDropdownForUser(username);
    }
}
