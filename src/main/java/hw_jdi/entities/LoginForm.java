package hw_jdi.entities;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw_jdi.JdiUser;

public class LoginForm extends Form<JdiUser> {

    @Css("#name")
    public TextField username;

    @Css("#password")
    public TextField password;

    @Css("#login-button")
    public Button submit;

    public void login(final JdiUser jdiUser) {
        username.setValue(jdiUser.getLogin());
        password.setValue(jdiUser.getPassword());
        submit.click();
    }
}
