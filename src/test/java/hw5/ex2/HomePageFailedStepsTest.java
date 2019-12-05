package hw5.ex2;

import hw5.AbstractBaseTest;
import hw5.AttachmentListener;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static hw3.Constants.*;

@Features({@Feature("Failed home page interface"), @Feature("Exercise2")})
@Listeners(AttachmentListener.class)
public class HomePageFailedStepsTest extends AbstractBaseTest {

    private HomePageSteps steps;

    @BeforeMethod()
    @Override
    public void setUp() {
        super.setUp();
        steps = new HomePageSteps(driver);
    }

    @Stories({@Story("Test home page functionality"),
                @Story("Compare page title with incorrect")})
    @Test
    public void homePageFailedTest() {
        steps.openEpamJdiSite();
        steps.login(userInfo.getUsername(), userInfo.getPassword());
        steps.usernameOnTheHomePageShouldBeDisplayed();
        steps.usernameOnTheHomePageShouldBe(userInfo.getUsernameLabel());

        // Failed here
        steps.homePageTitleShouldBe(HOME_PAGE_TITLE + "1");
/*
        steps.headerItemsShouldBeDisplayed();
        steps.headerItemsShouldHaveCount(HEADER_ITEM_COUNT);
        steps.headerItemsShouldContain(HEADER_ITEM_NAMES.get(0));
        steps.headerItemsShouldContain(HEADER_ITEM_NAMES.get(1));
        steps.headerItemsShouldContain(HEADER_ITEM_NAMES.get(2));
        steps.headerItemsShouldContain(HEADER_ITEM_NAMES.get(3));

        steps.homePageImagesShouldBeDisplayed();
        steps.homePageImagesCountShouldBe(IMAGE_COUNT);

        steps.homePageTextsUnderImagesShouldBeDisplayed();
        steps.homePageTextsUnderImagesCountShouldBe(IMAGE_COUNT);
        steps.homePageTextUnderImageShouldBe(1, TEXTS_UNDER_IMAGES.get(0));
        steps.homePageTextUnderImageShouldBe(2, TEXTS_UNDER_IMAGES.get(1));
        steps.homePageTextUnderImageShouldBe(3, TEXTS_UNDER_IMAGES.get(2));
        steps.homePageTextUnderImageShouldBe(4, TEXTS_UNDER_IMAGES.get(3));

        steps.homePageFirstHeaderShouldBeDisplayed();
        steps.homePageFirstHeaderShouldBe(FIRST_HEADER_TEXT);
        steps.homePageSecondHeaderShouldBeDisplayed();
        steps.homePageSecondHeaderShouldBe(SECOND_HEADER_TEXT);

        steps.homePageIframeShouldBeDisplayed();
        steps.homePageSwitchToIframe();
        steps.homePageIframeShouldContainsEpamLogo();

        steps.homePageSwitchToOriginalWindow();
        steps.homePageURLAfterSwitchShouldBe(HOME_URL);

        steps.homePageSubHeaderTextShouldBeDisplayed();
        steps.homePageSubHeaderTextShouldBe(SUBHEADER_TEXT);

        steps.homePageSubHeaderLinkShouldBe(SUBHEADER_LINK_TEXT);

        steps.homePageLeftSectionShouldBeDisplayed();

        steps.homePageFooterShouldBeDisplayed();
 */
    }
}
