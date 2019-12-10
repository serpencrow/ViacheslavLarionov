package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.AbstractBaseStep;
import hw6.Utils;
import hw6.WebDriverSingleton;
import hw6.enums.ButtonType;
import hw6.enums.MenuType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static hw6.enums.MenuSection.*;
import static hw6.enums.MenuType.HEADER_MENU;
import static hw6.enums.MenuType.LEFT_MENU;
import static org.testng.Assert.*;

public class AssertionStep extends AbstractBaseStep {

    @Then("^username should be '([^\"]+)' on Home Page$")
    public void usernameShoudlBeOnTheHomePage(final String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Then("browser title should be '([^\"]+)'$")
    public void browserTitleShouldBe(final String titleName) {
        assertEquals(homePage.getTitle(), titleName);
    }

    @Then("'([^\"]+)' header items should be displayed on the Home Page$")
    public void headerItemsShouldHaveCount(final String itemCount) {
        assertEquals(homePage.getHeaderItemsCount(), Integer.parseInt(itemCount));
    }

    @Then("benefit images should be displayed on the Home Page$")
    public void homePageTextsUnderImagesShouldBeDisplayed() {
        assertTrue(homePage.areAllImagesDisplayed());
    }

    @Then("^'([^\"]+)' benefit images should be on the Home Page$")
    public void benefitImagesOnTheHomePageShouldHaveCount(final String count) {
        assertEquals(homePage.getImagesCount(), Integer.parseInt(count));
    }

    @Then("texts under images should be displayed on the Home Page")
    public void textsUnderImagesShoudlBeDisplayedOnTheHomePage() {
        assertTrue(homePage.areAllTextsUnderImagesDisplayed());
    }

    @Then("^'([^\"]+)' texts under images should be on the Home Page$")
    public void textsUnderIamgesOnTheHomePageShoudlHaveCount(final String count) {
        assertEquals(homePage.getImageTextsCount(), Integer.parseInt(count));
    }

    @Then("^service dropdown should be displayed in '(header|left)' menu on Home Page$")
    public void serviceDropdownShouldBeDisplayedInMenu(final String menuTypeName) {
        MenuType menuType = null;

        switch (menuTypeName){
            case "header":
                menuType = HEADER_MENU;
                break;

            case "left":
                menuType = LEFT_MENU;
                break;
        }
        assertTrue(homePage.areAllMenuItemsInSectionDisplayed(Objects
                .requireNonNull(menuType), SERVICE_SECTION));
    }

    @Then("^service subcategories in '(header|left)' menu should contain options$")
    public void serviceSubcategoriesShouldContainOptionInHeaderMenu(final String menuTypeName,
                                                                    final List<String> optionNames) {
        MenuType menuType = null;
        switch (menuTypeName) {
            case "header":
                menuType = HEADER_MENU;
                break;

            case "left":
                menuType = LEFT_MENU;
                break;
        }
        for (String optionName : optionNames) {
            assertTrue(homePage.isItemContainsInMenuSection(Objects
                    .requireNonNull(menuType), SERVICE_SECTION, optionName));
        }
    }

    @Then("^I should see that page has URL '([^\"]+)'$")
    public void iShouldSeeThatPageHasUrl(final String url) {
        assertEquals(WebDriverSingleton.INSTANCE.getDriver().getCurrentUrl(), url);
    }

    @Then("^4 checkboxes should be displayed on Different Elements page$")
    public void allCheckboxesShouldBeDisplayed() {
        assertTrue(differentElementsPage.isAllButtonTypeListDisplayed(ButtonType.CHECKBOX));
    }

    @Then("^4 radiobuttons should be displayed on Different Elements Page$")
    public void radiobuttonsShouldHaveCount() {
        assertTrue(differentElementsPage.isAllButtonTypeListDisplayed(ButtonType.RADIOBUTTON));
    }

    @Then("^2 buttons should be displayed on the DifferentElements page$")
    public void buttonsShouldHaveCount() {
        assertTrue(differentElementsPage.isDefaultButtonDisplayed()
                && differentElementsPage.isButtonDisplayed());
    }

    @Then("^dropdown should be displayed on DifferentElements page$")
    public void dropdownShouldBeDisplayedOnTheDifferentElementsPage() {
        assertTrue(differentElementsPage.isDropdownColorsDisplayed());
    }

    @Then("^right section should be displayed on Different Elements Page$")
    public void rightSectionShouldBe() {
        assertTrue(differentElementsPage.isRightSectionDisplayed());
    }

    @Then("^left section should be displayed on Different Elements Page$")
    public void leftSectionShouldBe() {
        assertTrue(differentElementsPage.isLeftSectionDisplayed());
    }

    @Then("^I should see that '(checkbox|radiobutton)' with name '([^\"]+)' is unchecked$")
    public void iShouldSeeThatButtonUnchecked(final String buttonTypeName,
                                              final String buttonName) {
        switch (buttonTypeName) {
            case "checkbox":
                assertFalse(differentElementsPage.isCheckboxSelected(buttonName));
                break;

            case "radiobutton":
                assertFalse(differentElementsPage.isRadioButtonSelected(buttonName));
                break;
        }
    }

    @Then("^I should see that first log row is displayed$")
    public void iShouldSeeThatFirstLogRowIsDisplayed() {
        assertTrue(differentElementsPage.isFirstLogRowDisplayed());
    }

    @Then("^first log row should contain '([^\"]+)'$")
    public void iShouldSeeThatFirstLogRowContainsStatusAboutButton(final String elementStatus) {
        assertTrue(differentElementsPage.isFirstLogRowContains(elementStatus));
    }

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(final String browserTitleName) {
        browserTitleShouldBe(browserTitleName);
    }

    @Then("^6 NumberType Dropdowns should be displayed on Users Table on User Table Page$")
    public void sixNumberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(Utils.isElementsListDisplayed(userTablePage.getDropdowns()));
    }

    @Then("^6 User names should be displayed on Users Table on User Table Page$")
    public void sixUserNamesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(Utils.isElementsListDisplayed(userTablePage.getUsernames()));
    }

    @Then("^6 Description images should be displayed on Users Table on User Table Page$")
    public void sixIamgesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(Utils.isElementsListDisplayed(userTablePage.getDescriptionImages()));
    }

    @Then("^6 Description texts under images should be displayed on Users Table on User Table Page$")
    public void sixTextsShouldBeDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(Utils.isElementsListDisplayed(userTablePage.getDescriptions()));
    }

    @Then("^6 checkboxes should be displayed on Users Table on User Table Page$")
    public void sixCheckboxesShouldBeDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(Utils.isElementsListDisplayed(userTablePage.getCheckboxes()));
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(final DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        List<String> tableNumbers = new ArrayList<>();
        List<String> tableUsernames = new ArrayList<>();
        List<String> tableDescriptions = new ArrayList<>();

        for (Map<String, String> stringStringMap : table) {
            tableNumbers.add(stringStringMap.get("Number"));
            tableUsernames.add(stringStringMap.get("User"));
            tableDescriptions.add(stringStringMap.get("Description"));
        }

        assertTrue(Utils.isElementsListContainsAll(
                Utils.getWebElementTexts(userTablePage.getNumbers()),
                tableNumbers)
        );
        assertTrue(Utils.isElementsListContainsAll(
                Utils.getWebElementTexts(userTablePage.getUsernames()),
                tableUsernames)
        );

        assertTrue(Utils.isElementsListContainsAll(
                Utils.getWebElementTexts(userTablePage.getDescriptions()),
                tableDescriptions)
        );
    }

    @Then("^1 log row has '([^\"]+)' text in log section$")
    public void firstLogRowHasTextInLogSection(final String logText) {
        assertTrue(userTablePage.isFirstLogContains(logText));
    }

    @Then("^droplist for user '([^\"]+)' should contain values$")
    public void droplistShouldContainValues(final String username,
                                            final DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        List<String> tableDropdownNames = new ArrayList<>();
        table.forEach(tableRow -> tableDropdownNames.add(tableRow.get("Dropdown Values")));

        assertTrue(Utils.isElementsListContainsAll(
                Utils.getWebElementTexts(userTablePage
                        .getDroplistByUsername(username)),
                tableDropdownNames
        ));
    }
}
