package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTest {

    protected WebDriver driver;

    protected UserInfo userInfo;


    @BeforeSuite
    public void suiteSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        // setup implicit waitings
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);

        // maximize window
        driver.manage().window().maximize();

        userInfo = Utils.getUserInfoFromPropertyFile(Constants.PATH_TO_PROPERTIES);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
