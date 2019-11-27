package hw3;

import hw3.steps.Exercise1Steps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Exercise1StepsTest extends AbstractBaseTest {

    private Exercise1Steps steps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new Exercise1Steps(driver);
    }

    @Test
    public void homePageTest() {
        steps.openEpamJdiSite();
        steps.login(userInfo.getUsername(), userInfo.getPassword());
        steps.usernameOnTheHomePageShouldBeDisplayed();
        steps.usernameOnTheHomePageShouldBe(userInfo.getUsernameLabel());

        steps.homePageTitleShouldBe(Constants.HOME_PAGE_TITLE);

        steps.headerItemsShouldBeDisplayed();
        steps.headerItemsShouldHaveCount(Constants.HEADER_ITEM_COUNT);
        steps.headerItemsShouldContain(Constants.HEADER_ITEM_NAMES.get(0));
        steps.headerItemsShouldContain(Constants.HEADER_ITEM_NAMES.get(1));
        steps.headerItemsShouldContain(Constants.HEADER_ITEM_NAMES.get(2));
        steps.headerItemsShouldContain(Constants.HEADER_ITEM_NAMES.get(3));

        steps.homePageImagesShouldBeDisplayed();
        steps.homePageImagesCountShouldBe(Constants.IMAGE_COUNT);

        steps.homePageTextsUnderImagesShouldBeDisplayed();
        steps.homePageTextsUnderImagesCountShouldBe(Constants.IMAGE_COUNT);
        steps.homePageTextsUnderImagesShouldBe(Constants.TEXTS_UNDER_IMAGES);;

        steps.homePageFirstHeaderShouldBeDisplayed();
        steps.homePageFirstHeaderShouldBe(Constants.FIRST_HEADER_TEXT);
        steps.homePageSecondHeaderShouldBeDisplayed();
        steps.homePageSecondHeaderShouldBe(Constants.SECOND_HEADER_TEXT);

        steps.homePageIframeShouldBeDisplayed();
        steps.homePageSwitchToIframe();
        steps.homePageIframeShouldContainsEpamLogo();

        steps.homePageSwitchToOriginalWindow();
        steps.homePageURLAfterSwitchShouldBe(Constants.HOME_URL);

        steps.homePageSubHeaderTextShouldBeDisplayed();
        steps.homePageSubHeaderTextShouldBe(Constants.SUBHEADER_TEXT);

        steps.homePageSubHeaderLinkShouldBe(Constants.SUBHEADER_LINK_TEXT);

        steps.homePageLeftSectionShouldBeDisplayed();

        steps.homePageFooterShouldBeDisplayed();
    }
}
