package hw3.steps;

import hw3.enums.MenuSection;
import hw3.enums.MenuType;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1Steps extends BaseSteps {

    public Exercise1Steps(final WebDriver driver) {
        super(driver);
    }

    public void homePageTitleShouldBe(final String titleName) {
        assertEquals(homePage.getTitle(), titleName);
    }

    public void headerItemsShouldBeDisplayed() {
        assertTrue(homePage
                .allMenuItemsInSectionAreDisplayed(MenuType.HEADER_MENU,
                        MenuSection.MAIN_SECTION));
    }

    public void headerItemsShouldHaveCount(final int count) {
        assertEquals(homePage.getHeaderItemsCount(), count);
    }

    public void headerItemsShouldContain(final String itemName) {
        assertTrue(homePage
                .itemContainsInMenuSection(MenuType.HEADER_MENU,
                        MenuSection.MAIN_SECTION, itemName));
    }

    public void homePageImagesCountShouldBe(final int count) {
        assertEquals(homePage.getImagesCount(), count);
    }

    public void homePageImagesShouldBeDisplayed() {
        assertTrue(homePage.allImagesAreDisplayed());
    }

    public void homePageTextsUnderImagesCountShouldBe(final int count) {
        assertEquals(homePage.getImageTextsCount(), count);
    }

    public void homePageTextsUnderImagesShouldBeDisplayed() {
        assertTrue(homePage.allTextsUnderImagesAreDisplayed());
    }

    public void homePageTextsUnderImagesShouldBe(final List<String> textsUnderImages) {
        assertEquals(homePage.getTextsUnderImages(), textsUnderImages);
    }

    public void homePageFirstHeaderShouldBeDisplayed() {
        assertTrue(homePage.firstHeaderIsDisplayed());
    }

    public void homePageFirstHeaderShouldBe(final String headerName) {
        assertEquals(homePage.getFirstHeaderText(), headerName);
    }

    public void homePageSecondHeaderShouldBeDisplayed() {
        assertTrue(homePage.secondHeaderIsDisplayed());
    }

    public void homePageSecondHeaderShouldBe(final String headerName) {
        assertEquals(homePage.getSecondHeaderText(), headerName);
    }

    public void homePageIframeShouldBeDisplayed() {
        assertTrue(homePage.iframeIsDisplayed());
    }

    public void homePageSwitchToIframe() {
        homePage.switchToIframe();
    }

    public void homePageIframeShouldContainsEpamLogo() {
        assertTrue(homePage.iframeHaveEpamLogo());
    }

    public void homePageSwitchToOriginalWindow() {
        homePage.switchToDefaultContent();
    }

    public void homePageURLAfterSwitchShouldBe(final String URL) {
        assertEquals(homePage.getCurrentUrl(), URL);
    }

    public void homePageSubHeaderTextShouldBeDisplayed() {
        assertTrue(homePage.subheaderIsDisplayed());
    }

    public void homePageSubHeaderTextShouldBe(final String subheaderText) {
        assertEquals(homePage.getSubheaderFieldText(), subheaderText);
    }

    public void homePageSubHeaderLinkShouldBe(final String subheaderLink) {
        assertEquals(homePage.getSubheaderLinkText(), subheaderLink);
    }

    public void homePageLeftSectionShouldBeDisplayed() {
        assertTrue(homePage.leftSectionIsDisplayed());
    }

    public void homePageFooterShouldBeDisplayed() {
        assertTrue(homePage.footerIsDisplayed());
    }
}
