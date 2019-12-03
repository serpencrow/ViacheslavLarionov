package hw4.ex2;

import hw4.BaseSteps;
import hw4.ex2.enums.*;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.testng.Assert.assertTrue;

public class Exercise2Steps extends BaseSteps {

    private MetalAndColorsPage metalAndColorsPage;

    public Exercise2Steps() {
        super();
        metalAndColorsPage = new MetalAndColorsPage();
    }

    public void resetDropdownVegetables() {
        metalAndColorsPage.clickDropdown(DropdownType.VEGETABLES);
        metalAndColorsPage.resetDropdownVegetables();
    }

    public void selectNumbers(final List<Numbers> numbersList) {
        if (isNotEmpty(numbersList)) {
            numbersList.forEach(number -> metalAndColorsPage.selectNumber(number));
        }
    }

    public void selectElements(final List<Elements> elementsList) {
        if (isNotEmpty(elementsList)) {
            elementsList.forEach(element -> metalAndColorsPage.selectElement(element));
        }
    }

    public void selectDropdownColor(final Colors color) {
        if (color != null) {
            metalAndColorsPage.clickDropdown(DropdownType.COLORS);
            metalAndColorsPage.selectDropdownColor(color);
        }
    }

    public void selectDropdownMetal(final Metals metal) {
        if (metal != null) {
            metalAndColorsPage.clickDropdown(DropdownType.METALS);
            metalAndColorsPage.selectDropdownMetal(metal);
        }
    }

    public void selectDropdownVegetables(final List<Vegetables> vegetablesList) {
        if (isNotEmpty(vegetablesList)) {
            metalAndColorsPage.clickDropdown(DropdownType.VEGETABLES);
            vegetablesList.forEach(vegetable ->
                    metalAndColorsPage.selectDropdownVegetable(vegetable));
        }
    }

    public void clickCalculateButton() {
        metalAndColorsPage.getCalculateButton().click();
    }

    public void clickSubmitButton() {
        metalAndColorsPage.getSubmitButton().click();
    }

    public List<String> getCurrentLogList() {
        return metalAndColorsPage.getCurrentLogList();
    }

    public void actualLogsShouldContainExpected(final List<String> actualLogs,
                                                final List<String> expectedLogs) {
        assertTrue(actualLogs.containsAll(expectedLogs));
    }

    public void clickUserMenuDropdown() {
        metalAndColorsPage.clickUserMenuDropdown();
    }

    public void clickLogoutButton() {
        metalAndColorsPage.clickLogoutButton();
    }
}
