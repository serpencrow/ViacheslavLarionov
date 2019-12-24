package hw_jdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.MetalsAndColorsFormData;
import hw_jdi.entities.MetalsAndColorsForm;

import java.util.List;
import java.util.stream.Collectors;

public class MetalsAndColorsPage extends WebPage {

    @FindBy(xpath = "//*[@class='form']")
    public MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results li")
    private WebList results;

    @Css("#submit-button")
    private Button submitButton;

    @Css("#user-icon")
    private Button userIcon;

    @Css(".logout button")
    private Button logout;

    public void logout() {
        userIcon.click();
        logout.click();
    }

    public void fillMetalsAndColorsForm(final MetalsAndColorsFormData formData) {
        metalsAndColorsForm.fill(formData);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<String> getLogListResults() {
        return results.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }
}
