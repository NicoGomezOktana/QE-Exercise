package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(id = "user-name")
    WebElementFacade usernameInputBox;

    @FindBy(id="password")
    WebElementFacade passwordInputBox;

    @FindBy(id = "login-button")
    WebElementFacade loginButton;

    public void loginAsUser(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
