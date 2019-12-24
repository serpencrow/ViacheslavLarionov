package hw_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw_jdi.enums.HeaderMenuItem;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class JdiSiteTest {

    private JdiUser jdiUser;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initSite(JdiSite.class);
        jdiUser = Utils.getUserInfoFromPropertyFile(Constants.USER_PROPERTIES_FILE);
    }

    @Test(dataProvider = "metalsAndColorsFormData",
            dataProviderClass = MetalsAndColorsFormDataProvider.class)
    public void jdiMetalsAndColorsPageTest(final MetalsAndColorsFormData formData) {
        JdiSite.open();
        JdiSite.login(jdiUser);

        String actualUserName = JdiSite.jdiHomePage.getUsername();
        assertEquals(actualUserName, jdiUser.getFullName(),
                String.format("Expected username: %s, but actual: %s", actualUserName,
                        jdiUser.getFullName()));

        JdiSite.jdiHomePage.clickOnHeaderMenuItem(HeaderMenuItem.METALS_AND_COLORS);
        JdiSite.metalsAndColorsPage.checkOpened();

        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(formData);
        JdiSite.metalsAndColorsPage.clickSubmitButton();

        List<String> expectedLogList = Utils.formExpectedLogListFromTestData(formData);
        List<String> actualLogList = JdiSite.metalsAndColorsPage.getLogListResults();
        assertEquals(expectedLogList, actualLogList,
                String.format("Expected list: %s, but actual is: %s", expectedLogList, actualLogList));

        JdiSite.metalsAndColorsPage.logout();
    }

    @AfterSuite()
    public void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
