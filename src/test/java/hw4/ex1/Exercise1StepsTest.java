package hw4.ex1;

import hw4.AbstractBaseTest;
import hw4.Constants;
import hw4.ex1.enums.ServiceSubcategories;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1StepsTest extends AbstractBaseTest {

    private Exercise1Steps steps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new Exercise1Steps();
    }

    @Test
    public void testExercise1() {
        steps.titleShouldBe(Constants.HOMEPAGE_TITLE);

        steps.login(userInfo.getUsername(), userInfo.getPassword());
        steps.usernameOnTheHomePageShouldBeDisplayed();
        steps.usernameOnTheHomePageShouldBe(userInfo.getUsernameLabel());

        steps.headerMenuItemClick(Constants.SERVICE);
        steps.headerServiceDropdownShouldContainItem(ServiceSubcategories.SUPPORT);
        steps.headerServiceDropdownShouldContainItem(ServiceSubcategories.DATES);
        steps.headerServiceDropdownShouldContainItem(ServiceSubcategories.COMPLEX_TABLE);
        steps.headerServiceDropdownShouldContainItem(ServiceSubcategories.SIMPLE_TABLE);
        steps.headerServiceDropdownShouldContainItem(ServiceSubcategories.TABLE_WITH_PAGES);
        steps.headerServiceDropdownShouldContainItem(ServiceSubcategories.DIFFERENT_ELEMENTS);

        steps.leftMenuItemClick(Constants.SERVICE);
        steps.leftServiceDropdownShouldContainItem(ServiceSubcategories.SUPPORT);
        steps.leftServiceDropdownShouldContainItem(ServiceSubcategories.DATES);
        steps.leftServiceDropdownShouldContainItem(ServiceSubcategories.COMPLEX_TABLE);
        steps.leftServiceDropdownShouldContainItem(ServiceSubcategories.SIMPLE_TABLE);
        steps.leftServiceDropdownShouldContainItem(ServiceSubcategories.TABLE_WITH_PAGES);
        steps.leftServiceDropdownShouldContainItem(ServiceSubcategories.DIFFERENT_ELEMENTS);

        steps.headerMenuItemClick(Constants.SERVICE);
        steps.headerServiceDropdownMenuItemClick(ServiceSubcategories.TABLE_WITH_PAGES);
        steps.currentUrlShouldBe(Constants.TABLE_WITH_PAGES_URL);

        steps.dropdownValueShouldBe(Constants.FIRST_DROPDOWN_VALUE);

        steps.leftSectionShouldBeDisplayed();
        steps.rightSectionShouldBeDisplayed();

        steps.setDropdownValue(Constants.SECOND_DROPDOWN_VALUE);
        steps.dropdownValueShouldBe(Constants.SECOND_DROPDOWN_VALUE);
        steps.secondLogListRowShouldContain(Constants.DROPDOWN_LOG_ROW
                + Constants.SECOND_DROPDOWN_VALUE);

        steps.amountOfEntitiesInTableShouldBe(Constants.SECOND_DROPDOWN_VALUE);

        steps.fillSearchTextField(Constants.SEARCH_TEXT);
        steps.tableEntitiesShouldHaveSearchOption(Constants.SEARCH_TEXT);

        steps.clickUserMenuDropdown();
        steps.clickLogoutButton();
    }
}
