package hw_jdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw_jdi.JdiUser;
import hw_jdi.entities.LoginForm;
import hw_jdi.enums.HeaderMenuItem;

public class JdiHomePage extends WebPage {

    @Css("#user-name")
    private Text username;

    @Css("#user-icon")
    private Button userIcon;

    @FindBy(linkText = "Metals & Colors")
    private Button metalsAndColorsButton;

    @Css(".navbar-nav.m-l8 li")
    private WebList headerMenuItems;

    public LoginForm loginForm;

    public void login(final JdiUser jdiUser) {
        userIcon.click();
        loginForm.login(jdiUser);
    }

    public String getUsername() {
        return username.getText();
    }

    public void clickOnHeaderMenuItem(final HeaderMenuItem headerMenuItem) {
        headerMenuItems.select(headerMenuItem.getItemName());
    }
}
