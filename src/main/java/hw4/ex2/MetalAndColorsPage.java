package hw4.ex2;

import com.codeborne.selenide.SelenideElement;
import hw4.AbstractBasePage;
import hw4.ex2.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class MetalAndColorsPage extends AbstractBasePage {

    @FindBy(id = "odds-selector")
    private SelenideElement oddSelectors;

    @FindBy(id = "even-selector")
    private SelenideElement evenSelectors;

    @FindBy(id = "elements-checklist")
    private SelenideElement elements;

    @FindBy(id = "colors")
    private SelenideElement dropdownColors;

    @FindBy(id = "metals")
    private SelenideElement dropdownMetals;

    @FindBy(id = "vegetables")
    private SelenideElement dropdownVegetables;

    @FindBy(id = "calculate-button")
    private SelenideElement calculateButton;

    @FindBy(id = "submit-button")
    private SelenideElement submitButton;

    @FindBy(xpath = "//ul[contains(@class, 'results')]")
    private SelenideElement resultLogList;

    public MetalAndColorsPage() {
        super();
    }

    public void resetDropdownVegetables() {
        dropdownVegetables.findAll(By.tagName("li")).forEach(dropdownElement -> {
            if (dropdownElement.find(By.tagName("input")).is(selected)) {
                dropdownElement.click();
            }
        });
    }

    public void clickDropdown(final DropdownType dropdownType) {
        switch (dropdownType) {
            case COLORS:
                dropdownColors.find(By.cssSelector(".btn-group .dropdown-toggle .caret"))
                        .click();
                break;

            case METALS:
                dropdownMetals.find(By.cssSelector(".btn-group .dropdown-toggle .caret"))
                        .click();
                break;

            case VEGETABLES:
                dropdownVegetables.find(By.cssSelector(".salad .btn .caret"))
                        .click();
                break;
        }
    }

    public void selectDropdownColor(final Colors color) {
        dropdownColors.find(By.tagName("ul"))
                .find(By.linkText(color.getColorName()))
                .click();
    }

    public void selectDropdownMetal(final Metals metal) {
        dropdownMetals.find(By.tagName("ul"))
                .find(By.linkText(metal.getMetalName()))
                .click();
    }

    public void selectDropdownVegetable(final Vegetables vegetable) {
        dropdownVegetables.findAll(By.tagName("li"))
                .find(text(vegetable.getVegetableName()))
                .click();
    }

    public void selectElement(final Elements element) {
        this.elements.findAll(By.tagName("p"))
                .find(text(element.getElementName()))
                .click();
    }

    public void selectNumber(final Numbers number) {
        (Integer.parseInt(number.getNumberValue()) % 2 == 0
                ? evenSelectors
                : oddSelectors
        ).findAll(By.tagName("p"))
                .find(text(number.getNumberValue()))
                .click();
    }

    public SelenideElement getCalculateButton() {
        return calculateButton;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public List<String> getCurrentLogList() {
        return resultLogList.findAll(By.tagName("li")).texts();
    }
}
