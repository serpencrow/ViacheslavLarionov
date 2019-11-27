package hw3.steps;

import hw3.DifferentElementsPage;
import hw3.enums.ButtonType;
import hw3.enums.MenuSection;
import hw3.enums.MenuType;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.*;

public class Exercise2Steps extends BaseSteps {

    private DifferentElementsPage differentElementsPage;

    public Exercise2Steps(final WebDriver driver) {
        super(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    public void clickOnItemInMenu(final MenuType menuType, final MenuSection menuSection,
                                  final String itemName) {
        homePage.clickOnItemInMenuSection(menuType, menuSection, itemName);
    }

    public void serviceDropdownShouldBeDisplayedInMenu(MenuType menuType) {
        assertTrue(homePage.isAllMenuItemsInSectionDisplayed(menuType, MenuSection.SERVICE_SECTION));
    }

    public void serviceSubcategoriesShouldContainOptionsInMenu(final MenuType menuType,
                                                               final List<String> options) {
        options.forEach(option -> assertTrue(homePage
                .isItemContainsInMenuSection(menuType, MenuSection.SERVICE_SECTION, option)));
    }

    public void currentUrlPageShouldBe(final String currentURL) {
        assertEquals(homePage.getCurrentUrl(), currentURL);
    }

    public void checkboxShouldBeDisplayed(final String checkboxName) {
        assertTrue(differentElementsPage
                .isButtonTypeDisplayed(ButtonType.CHECKBOX, checkboxName));
    }

    public void radioButtonShouldBeDisplayed(final String radiobuttonName) {
        assertTrue(differentElementsPage
                .isButtonTypeDisplayed(ButtonType.RADIOBUTTON, radiobuttonName));
    }

    public void checkboxCountShouldBe(final int count) {
        assertEquals(differentElementsPage.getCheckboxCount(), count);
    }

    public void radioButtonsCountShouldBe(final int count) {
        assertEquals(differentElementsPage.getRadioButtonsCount(), count);
    }

    public void dropdownShouldBeDisplayed() {
        assertTrue(differentElementsPage.isDropdownColorsDisplayed());
    }

    public void defaultButtonShouldBeDisplayed() {
        assertTrue(differentElementsPage.isDefaultButtonDisplayed());
    }

    public void buttonShouldBeDisplayed() {
        assertTrue(differentElementsPage.isButtonDisplayed());
    }

    public void rightSectionShouldBe() {
        assertTrue(differentElementsPage.isRightSectionDisplayed());
    }

    public void leftSectionShouldBe() {
        assertTrue(differentElementsPage.isLeftSectionDisplayed());
    }

    public void selectCheckbox(final String checkboxName) {
        differentElementsPage.selectButton(ButtonType.CHECKBOX, checkboxName);
    }

    public void selectRadioButton(final String radioButtonName) {
        differentElementsPage.selectButton(ButtonType.RADIOBUTTON, radioButtonName);
    }

    public void checkboxShouldBeSelected(final String checkboxName) {
        assertTrue(differentElementsPage.isCheckboxSelected(checkboxName));
    }

    public void checkboxShouldBeUnselected(final String checkboxName) {
        assertFalse(differentElementsPage.isCheckboxSelected(checkboxName));
    }


    public void radioButtonShouldBeSelected(final String radioButtonName) {
        assertTrue(differentElementsPage.isRadioButtonSelected(radioButtonName));
    }

    public void logRowShouldBeExists(final String logRow) {
        assertTrue(differentElementsPage.isFirstLogRowContains(logRow));
    }

    public void clickOnDropdownColorsMenu() {
        differentElementsPage.clickOnDropdownMenu();
    }

    public void selectDropdownColor(final String color) {
        differentElementsPage.selectDropdownColor(color);
    }

    public void dropdownColorShouldBe(final String color) {
        assertEquals(differentElementsPage.getSelectedColor(), color);
    }

    public void chosenCheckboxesShouldBeUnselected(final List<String> checkboxNames) {
        checkboxNames.forEach(checkboxName ->
                assertFalse(differentElementsPage.isCheckboxSelected(checkboxName)));
    }
}
