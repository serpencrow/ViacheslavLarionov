package hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractBaseTest {

    protected UserInfo userInfo;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100;
        //Configuration.headless = true;

        open(Constants.HOMEPAGE_URL);
        userInfo = Utils.getUserInfoFromPropertyFile(Constants.PATH_TO_PROPERTIES);
    }
}
