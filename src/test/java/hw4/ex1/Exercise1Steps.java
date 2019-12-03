package hw4.ex1;

import hw4.BaseSteps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;

public class Exercise1Steps extends BaseSteps {

    private TableWithPagesPage tableWithPagesPage;

    public Exercise1Steps() {
        super();
        tableWithPagesPage = new TableWithPagesPage();
    }

    public void dropdownValueShouldBe(final int dropdownValue) {
        tableWithPagesPage.getEntriesCountSelector()
                .shouldHave(value(Integer.toString(dropdownValue)));
    }

    public void leftSectionShouldBeDisplayed() {
        tableWithPagesPage.getLeftSection().shouldBe(visible);
    }

    public void rightSectionShouldBeDisplayed() {
        tableWithPagesPage.getRightSection().shouldBe(visible);
    }

    public void setDropdownValue(final int dropdownValue) {
        tableWithPagesPage.getEntriesCountSelector()
                .selectOptionByValue(Integer.toString(dropdownValue));
    }

    public void secondLogListRowShouldContain(final String logText) {
        tableWithPagesPage.getLogList().get(1)
                .shouldBe(visible)
                .shouldHave(text(logText));
    }

    public void amountOfEntitiesInTableShouldBe(final int entitiesCount) {
        tableWithPagesPage.getEntitiesFromTable()
                .shouldHaveSize(entitiesCount);
    }

    public void fillSearchTextField(final String searchText) {
        tableWithPagesPage.fillSearchTextField(searchText);
    }

    public void tableEntitiesShouldHaveSearchOption(final String searchText) {
        tableWithPagesPage.getTableEntitiesNowOptions()
                .shouldHave(sizeGreaterThan(0))
                .forEach(option -> option.shouldBe(visible).shouldHave(text(searchText)));
    }

    public void clickUserMenuDropdown() {
        tableWithPagesPage.clickUserMenuDropdown();
    }

    public void clickLogoutButton() {
        tableWithPagesPage.clickLogoutButton();
    }
}
