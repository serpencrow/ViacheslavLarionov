package hw6;

import org.openqa.selenium.WebDriver;

public class AbstractBaseStep {

    protected static HomePage homePage;

    protected static DifferentElementsPage differentElementsPage;

    protected static UserTablePage userTablePage;

    public AbstractBaseStep() {
        WebDriver driver = WebDriverSingleton.INSTANCE.getDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
