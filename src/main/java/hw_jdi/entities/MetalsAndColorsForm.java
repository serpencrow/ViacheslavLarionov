package hw_jdi.entities;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.MetalsAndColorsFormData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsFormData> {

    @XPath("//div[@id='summary-block']//label")
    private WebList summaryRadiobuttons;

    @XPath("//div[@id='elements-block']//p")
    private WebList elements;

    @XPath("//div[@id='colors']//li")
    private WebList colorDropdown;

    @XPath("//div[@id='metals']//a")
    private WebList metalsDropdown;

    @XPath("//div[@id='vegetables']//li")
    private WebList vegetablesDropdown;

    @XPath("//div[@id='colors']//button")
    private Button colorDropdownExpander;

    @XPath("//div[@id='metals']//button")
    private Button metalsDropdownExpander;

    @XPath("//div[@id='vegetables']//button")
    private Button vegetablesDropdownExpander;

    public void fillForm(final MetalsAndColorsFormData metalsAndColorsFormData) {
        metalsAndColorsFormData.getSummary().forEach(summary -> {
            summaryRadiobuttons.select(Integer.toString(summary));
        });

        metalsAndColorsFormData.getElements().forEach(elements::select);

        colorDropdownExpander.click();
        colorDropdown.select(metalsAndColorsFormData.getColor());

        metalsDropdownExpander.click();
        metalsDropdown.select(metalsAndColorsFormData.getMetals());

        vegetablesDropdownExpander.click();
        vegetablesDropdown.select("Vegetables");
        metalsAndColorsFormData.getVegetables().forEach(vegetablesDropdown::select);
    }
}
