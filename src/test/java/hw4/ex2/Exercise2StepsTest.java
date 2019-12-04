package hw4.ex2;

import hw4.AbstractBaseTest;
import hw4.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static hw4.Utils.*;

public class Exercise2StepsTest extends AbstractBaseTest {

    private Exercise2Steps steps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new Exercise2Steps();
    }

    @Test(dataProviderClass = TestDataProvider .class, dataProvider = "getFormTestData")
    public void testExercise2(final TestData testData) {
        steps.titleShouldBe(Constants.HOMEPAGE_TITLE);
        steps.login(userInfo.getUsername(), userInfo.getPassword());
        steps.usernameOnTheHomePageShouldBeDisplayed();
        steps.usernameOnTheHomePageShouldBe(userInfo.getUsernameLabel());

        steps.headerMenuItemClick(Constants.METALS_AND_COLORS);

        steps.resetDropdownVegetables();

        steps.selectNumbers(testData.getNumbers());
        steps.selectElements(testData.getElements());
        steps.selectDropdownColor(testData.getColor());
        steps.selectDropdownMetal(testData.getMetal());
        steps.selectDropdownVegetables(testData.getVegetables());

        steps.clickSubmitButton();
        steps.clickCalculateButton();

        List<String> expectedLogs = formExpectedLogListFromTestData(testData);
        List<String> actualLogs = formActualLogListFromCurrentAndTestData(
                steps.getCurrentLogList(),
                testData
        );
        steps.actualLogsShouldContainExpected(actualLogs, expectedLogs);

        steps.clickUserMenuDropdown();
        steps.clickLogoutButton();
    }
}
