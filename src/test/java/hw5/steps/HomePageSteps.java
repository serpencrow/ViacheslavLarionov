package hw5.steps;

import hw5.enums.MenuSection;
import hw5.enums.MenuType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BaseSteps {

    public HomePageSteps(final WebDriver driver) {
        super(driver);
    }

    @Step("Page title should be {0}")
    public void homePageTitleShouldBe(final String titleName) {
        assertEquals(homePage.getTitle(), titleName);
    }

    @Step("Header items should be displayed")
    public void headerItemsShouldBeDisplayed() {
        assertTrue(homePage
                .areAllMenuItemsInSectionDisplayed(MenuType.HEADER_MENU,
                        MenuSection.MAIN_SECTION));
    }

    @Step("Header items count should be {0}")
    public void headerItemsShouldHaveCount(final int count) {
        assertEquals(homePage.getHeaderItemsCount(), count);
    }

    @Step("Header items should contain {0}")
    public void headerItemsShouldContain(final String itemName) {
        assertTrue(homePage
                .isItemContainsInMenuSection(MenuType.HEADER_MENU,
                        MenuSection.MAIN_SECTION, itemName));
    }

    @Step("Benefit images should be displayed")
    public void homePageImagesShouldBeDisplayed() {
        assertTrue(homePage.areAllImagesDisplayed());
    }

    @Step("Benefit images count should be {0}")
    public void homePageImagesCountShouldBe(final int count) {
        assertEquals(homePage.getImagesCount(), count);
    }

    @Step("Texts under images should be displayed")
    public void homePageTextsUnderImagesShouldBeDisplayed() {
        assertTrue(homePage.areAllTextsUnderImagesDisplayed());
    }

    @Step("Text count under images should be {0}")
    public void homePageTextsUnderImagesCountShouldBe(final int count) {
        assertEquals(homePage.getImageTextsCount(), count);
    }

    @Step("Text under image {0} should be {1}")
    public void homePageTextUnderImageShouldBe(final int imageNumber,
                                               final String textUnderImage) {
        assertEquals(homePage.getTextsUnderImages().get(imageNumber - 1), textUnderImage);
    }

    @Step("First Header should be displayed")
    public void homePageFirstHeaderShouldBeDisplayed() {
        assertTrue(homePage.isFirstHeaderDisplayed());
    }

    @Step("First header should be {0}")
    public void homePageFirstHeaderShouldBe(final String headerName) {
        assertEquals(homePage.getFirstHeaderText(), headerName);
    }

    @Step("Second header should be displayed")
    public void homePageSecondHeaderShouldBeDisplayed() {
        assertTrue(homePage.isSecondHeaderDisplayed());
    }

    @Step("Second header should be {0}")
    public void homePageSecondHeaderShouldBe(final String headerName) {
        assertEquals(homePage.getSecondHeaderText(), headerName);
    }

    @Step("Iframe should be displayed")
    public void homePageIframeShouldBeDisplayed() {
        assertTrue(homePage.isIframeDisplayed());
    }

    @Step("Switch from Home page to inner iframe")
    public void homePageSwitchToIframe() {
        homePage.switchToIframe();
    }

    @Step("Iframe should contain EPAM logo")
    public void homePageIframeShouldContainsEpamLogo() {
        assertTrue(homePage.iframeHaveEpamLogo());
    }

    @Step("Switch from iframe to Home page")
    public void homePageSwitchToOriginalWindow() {
        homePage.switchToDefaultContent();
    }

    @Step("Page URL should be {0}")
    public void homePageURLAfterSwitchShouldBe(final String URL) {
        assertEquals(homePage.getCurrentUrl(), URL);
    }

    @Step("Subheader text should be displayed")
    public void homePageSubHeaderTextShouldBeDisplayed() {
        assertTrue(homePage.isSubheaderDisplayed());
    }

    @Step("Subheader text should be {0}")
    public void homePageSubHeaderTextShouldBe(final String subheaderText) {
        assertEquals(homePage.getSubheaderFieldText(), subheaderText);
    }

    @Step("Subheader link text should be {0}")
    public void homePageSubHeaderLinkShouldBe(final String subheaderLink) {
        assertEquals(homePage.getSubheaderLinkText(), subheaderLink);
    }

    @Step("Left section should be displayed")
    public void homePageLeftSectionShouldBeDisplayed() {
        assertTrue(homePage.isLeftSectionDisplayed());
    }

    @Step("Right section should be displayed")
    public void homePageFooterShouldBeDisplayed() {
        assertTrue(homePage.isFooterDisplayed());
    }
}
