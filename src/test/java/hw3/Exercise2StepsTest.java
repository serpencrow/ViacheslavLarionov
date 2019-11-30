package hw3;

import hw3.enums.MenuSection;
import hw3.enums.MenuType;
import hw3.steps.Exercise2Steps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2StepsTest extends AbstractBaseTest {

    private Exercise2Steps steps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        steps = new Exercise2Steps(driver);
    }

    @Test
    public void differentPageTest() {
        steps.openEpamJdiSite();
        steps.login(userInfo.getUsername(), userInfo.getPassword());
        steps.usernameOnTheHomePageShouldBeDisplayed();
        steps.usernameOnTheHomePageShouldBe(userInfo.getUsernameLabel());

        steps.clickOnItemInMenu(MenuType.HEADER_MENU, MenuSection.MAIN_SECTION,
                Constants.HEADER_ITEM_NAMES.get(2));
        steps.serviceDropdownShouldBeDisplayedInMenu(MenuType.HEADER_MENU);
        steps.serviceSubcategoriesShouldContainOptionsInMenu(MenuType.HEADER_MENU,
                Constants.SERVICE_SUBCATEGORIES);

        steps.clickOnItemInMenu(MenuType.LEFT_SIDE_MENU, MenuSection.MAIN_SECTION,
                Constants.HEADER_ITEM_NAMES.get(2));
        steps.serviceDropdownShouldBeDisplayedInMenu(MenuType.LEFT_SIDE_MENU);
        steps.serviceSubcategoriesShouldContainOptionsInMenu(MenuType.LEFT_SIDE_MENU,
                Constants.SERVICE_SUBCATEGORIES);

        steps.clickOnItemInMenu(MenuType.HEADER_MENU, MenuSection.MAIN_SECTION,
                Constants.HEADER_ITEM_NAMES.get(2));
        steps.clickOnItemInMenu(MenuType.HEADER_MENU, MenuSection.SERVICE_SECTION,
                Constants.SERVICE_SUBCATEGORIES.get(5));
        steps.currentUrlPageShouldBe(Constants.DIFFERENT_ELEMENTS_PAGE);

        steps.checkboxShouldBeDisplayed(Constants.CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeDisplayed(Constants.CHECKBOX_NAMES.get(1));
        steps.checkboxCountShouldBe(Constants.CHECKBOX_COUNT);
        steps.radioButtonShouldBeDisplayed(Constants.RADIOBUTTON_NAME);
        steps.radioButtonsCountShouldBe(Constants.RADIOBUTTON_COUNT);
        steps.dropdownShouldBeDisplayed();
        steps.defaultButtonShouldBeDisplayed();
        steps.buttonShouldBeDisplayed();

        steps.rightSectionShouldBe();
        steps.leftSectionShouldBe();

        steps.selectCheckbox(Constants.CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeSelected(Constants.CHECKBOX_NAMES.get(0));
        steps.logRowShouldBeExists(Constants.CHECKBOX_NAMES.get(0) + Constants.CHECKBOX_TRUE_LOG);

        steps.selectCheckbox(Constants.CHECKBOX_NAMES.get(1));
        steps.checkboxShouldBeSelected(Constants.CHECKBOX_NAMES.get(1));
        steps.logRowShouldBeExists(Constants.CHECKBOX_NAMES.get(1) + Constants.CHECKBOX_TRUE_LOG);

        steps.selectRadioButton(Constants.RADIOBUTTON_NAME);
        steps.radioButtonShouldBeSelected(Constants.RADIOBUTTON_NAME);
        steps.logRowShouldBeExists(Constants.RADIOBUTTON_LOG + Constants.RADIOBUTTON_NAME);

        steps.clickOnDropdownColorsMenu();
        steps.selectDropdownColor(Constants.COLOR);
        steps.dropdownColorShouldBe(Constants.COLOR);
        steps.logRowShouldBeExists(Constants.SELECTION_LOG + Constants.COLOR);

        steps.selectCheckbox(Constants.CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeUnselected(Constants.CHECKBOX_NAMES.get(0));
        steps.logRowShouldBeExists(Constants.CHECKBOX_NAMES.get(0) + Constants.CHECKBOX_FALSE_LOG);

        steps.selectCheckbox(Constants.CHECKBOX_NAMES.get(1));
        steps.checkboxShouldBeUnselected(Constants.CHECKBOX_NAMES.get(1));
        steps.logRowShouldBeExists(Constants.CHECKBOX_NAMES.get(1) + Constants.CHECKBOX_FALSE_LOG);

        steps.chosenCheckboxesShouldBeUnselected(Constants.CHECKBOX_NAMES);
    }
}
