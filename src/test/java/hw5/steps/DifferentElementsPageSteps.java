package hw5.steps;

import hw5.DifferentElementsPage;
import hw5.enums.ButtonType;
import hw5.enums.MenuSection;
import hw5.enums.MenuType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class DifferentElementsPageSteps extends BaseSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(final WebDriver driver) {
        super(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Click on item {2} in {menuType.menuTypeName} in {menuSection.menuSectionName}")
    public void clickOnItemInMenu(final MenuType menuType, final MenuSection menuSection,
                                  final String itemName) {
        homePage.clickOnItemInMenuSection(menuType, menuSection, itemName);
    }

    @Step("Service dropdown should be displayed in {menuType.menuTypeName}")
    public void serviceDropdownShouldBeDisplayedInMenu(MenuType menuType) {
        assertTrue(homePage.areAllMenuItemsInSectionDisplayed(menuType, MenuSection.SERVICE_SECTION));
    }

    @Step("Service subcategories in {menuType.menuTypeName} should contain {1}")
    public void serviceSubcategoriesShouldContainOptionInMenu(final MenuType menuType,
                                                              final String option) {
       assertTrue(homePage.isItemContainsInMenuSection(menuType,
               MenuSection.SERVICE_SECTION, option));
    }

    @Step("Page URL should be {0}")
    public void currentUrlPageShouldBe(final String currentURL) {
        assertEquals(homePage.getCurrentUrl(), currentURL);
    }

    @Step("Checkbox {0} should be displayed")
    public void checkboxShouldBeDisplayed(final String checkboxName) {
        assertTrue(differentElementsPage
                .isButtonTypeDisplayed(ButtonType.CHECKBOX, checkboxName));
    }

    @Step("Radiobutton {0} should be displayed")
    public void radioButtonShouldBeDisplayed(final String radiobuttonName) {
        assertTrue(differentElementsPage
                .isButtonTypeDisplayed(ButtonType.RADIOBUTTON, radiobuttonName));
    }

    @Step("Checkbox count should be {0}")
    public void checkboxCountShouldBe(final int count) {
        assertEquals(differentElementsPage.getCheckboxCount(), count);
    }

    @Step("Radiobutton count should be {0}")
    public void radioButtonsCountShouldBe(final int count) {
        assertEquals(differentElementsPage.getRadioButtonsCount(), count);
    }

    @Step("Dropdown colors count should be displayed")
    public void dropdownShouldBeDisplayed() {
        assertTrue(differentElementsPage.isDropdownColorsDisplayed());
    }

    @Step("Default button should be displayed")
    public void defaultButtonShouldBeDisplayed() {
        assertTrue(differentElementsPage.isDefaultButtonDisplayed());
    }

    @Step("Button should be displayed")
    public void buttonShouldBeDisplayed() {
        assertTrue(differentElementsPage.isButtonDisplayed());
    }

    @Step("Right section should be displayed")
    public void rightSectionShouldBe() {
        assertTrue(differentElementsPage.isRightSectionDisplayed());
    }

    @Step("Left section should be displayed")
    public void leftSectionShouldBe() {
        assertTrue(differentElementsPage.isLeftSectionDisplayed());
    }

    @Step("Select {buttonType.buttonTypeName} by name '{buttonName}'")
    public void selectButtonTypeByName(final ButtonType buttonType,
                                       final String buttonName) {
        differentElementsPage.selectButton(buttonType, buttonName);
    }

    @Step("Checkbox {0} should be selected")
    public void checkboxShouldBeSelected(final String checkboxName) {
        assertTrue(differentElementsPage.isCheckboxSelected(checkboxName));
    }

    @Step("Checkbox {0} should be unselected")
    public void checkboxShouldBeUnselected(final String checkboxName) {
        assertFalse(differentElementsPage.isCheckboxSelected(checkboxName));
    }

    @Step("Radiobutton {0} should be selected")
    public void radioButtonShouldBeSelected(final String radioButtonName) {
        assertTrue(differentElementsPage.isRadioButtonSelected(radioButtonName));
    }

    @Step("Log row '{0}' should be exists")
    public void logRowShouldBeExists(final String logRow) {
        assertTrue(differentElementsPage.isFirstLogRowContains(logRow));
    }

    @Step("Click on dropdown colors menu")
    public void clickOnDropdownColorsMenu() {
        differentElementsPage.clickOnDropdownMenu();
    }

    @Step("Select dropdown color {0}")
    public void selectDropdownColor(final String color) {
        differentElementsPage.selectDropdownColor(color);
    }

    @Step("Dropdown color should be {0}")
    public void dropdownColorShouldBe(final String color) {
        assertEquals(differentElementsPage.getSelectedColor(), color);
    }
}
