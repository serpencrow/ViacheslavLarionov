package hw5.ex1;

import hw5.AbstractBaseTest;
import hw5.AttachmentListener;
import hw5.steps.DifferentElementsPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static hw5.Constants.*;
import static hw5.enums.ButtonType.*;
import static hw5.enums.ButtonType.CHECKBOX;
import static hw5.enums.MenuSection.MAIN_SECTION;
import static hw5.enums.MenuSection.SERVICE_SECTION;
import static hw5.enums.MenuType.HEADER_MENU;
import static hw5.enums.MenuType.LEFT_SIDE_MENU;

@Features({@Feature("Different Elements page interface"), @Feature("Exercise1")})
@Listeners(AttachmentListener.class)
public class DifferentElementsPageStepsTest extends AbstractBaseTest {

    private DifferentElementsPageSteps steps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        steps = new DifferentElementsPageSteps(driver);
    }

    @Stories({@Story("Login on the Home page"),
                @Story("Test Different Elements page functionality")})
    @Test
    public void differentPageTest() {
        steps.openEpamJdiSite();
        steps.login(userInfo.getUsername(), userInfo.getPassword());
        steps.usernameOnTheHomePageShouldBeDisplayed();
        steps.usernameOnTheHomePageShouldBe(userInfo.getUsernameLabel());

        steps.clickOnItemInMenu(HEADER_MENU, MAIN_SECTION,
                HEADER_ITEM_NAMES.get(2));
        steps.serviceDropdownShouldBeDisplayedInMenu(HEADER_MENU);

        SERVICE_SUBCATEGORIES.forEach(subcategory ->
                steps.serviceSubcategoriesShouldContainOptionInMenu(HEADER_MENU,
                        subcategory)
        );

        steps.clickOnItemInMenu(LEFT_SIDE_MENU, MAIN_SECTION,
                HEADER_ITEM_NAMES.get(2));
        steps.serviceDropdownShouldBeDisplayedInMenu(LEFT_SIDE_MENU);

        SERVICE_SUBCATEGORIES.forEach(subcategory ->
                steps.serviceSubcategoriesShouldContainOptionInMenu(LEFT_SIDE_MENU,
                        subcategory)
        );

        steps.clickOnItemInMenu(HEADER_MENU, MAIN_SECTION,
                HEADER_ITEM_NAMES.get(2));
        steps.clickOnItemInMenu(HEADER_MENU, SERVICE_SECTION,
                SERVICE_SUBCATEGORIES.get(5));
        steps.currentUrlPageShouldBe(DIFFERENT_ELEMENTS_PAGE);

        steps.checkboxShouldBeDisplayed(CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeDisplayed(CHECKBOX_NAMES.get(1));
        steps.checkboxCountShouldBe(CHECKBOX_COUNT);
        steps.radioButtonShouldBeDisplayed(RADIOBUTTON_NAME);
        steps.radioButtonsCountShouldBe(RADIOBUTTON_COUNT);
        steps.dropdownShouldBeDisplayed();
        steps.defaultButtonShouldBeDisplayed();
        steps.buttonShouldBeDisplayed();

        steps.rightSectionShouldBe();
        steps.leftSectionShouldBe();

        steps.selectButtonTypeByName(CHECKBOX, CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeSelected(CHECKBOX_NAMES.get(0));
        steps.logRowShouldBeExists(CHECKBOX_NAMES.get(0) + CHECKBOX_TRUE_LOG);

        steps.selectButtonTypeByName(CHECKBOX, CHECKBOX_NAMES.get(1));
        steps.checkboxShouldBeSelected(CHECKBOX_NAMES.get(1));
        steps.logRowShouldBeExists(CHECKBOX_NAMES.get(1) + CHECKBOX_TRUE_LOG);

        steps.selectButtonTypeByName(RADIOBUTTON, RADIOBUTTON_NAME);
        steps.radioButtonShouldBeSelected(RADIOBUTTON_NAME);
        steps.logRowShouldBeExists(RADIOBUTTON_LOG + RADIOBUTTON_NAME);

        steps.clickOnDropdownColorsMenu();
        steps.selectDropdownColor(COLOR);
        steps.dropdownColorShouldBe(COLOR);
        steps.logRowShouldBeExists(SELECTION_LOG + COLOR);

        steps.selectButtonTypeByName(CHECKBOX, CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeUnselected(CHECKBOX_NAMES.get(0));
        steps.logRowShouldBeExists(CHECKBOX_NAMES.get(0) + CHECKBOX_FALSE_LOG);

        steps.selectButtonTypeByName(CHECKBOX, CHECKBOX_NAMES.get(1));
        steps.checkboxShouldBeUnselected(CHECKBOX_NAMES.get(1));
        steps.logRowShouldBeExists(CHECKBOX_NAMES.get(1) + CHECKBOX_FALSE_LOG);

        steps.checkboxShouldBeUnselected(CHECKBOX_NAMES.get(0));
        steps.checkboxShouldBeUnselected(CHECKBOX_NAMES.get(1));
    }
}
