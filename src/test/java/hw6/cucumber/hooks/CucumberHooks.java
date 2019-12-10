package hw6.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // setup implicit waitings
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);

        // maximize window
        driver.manage().window().maximize();
        WebDriverSingleton.INSTANCE.setDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }
}
