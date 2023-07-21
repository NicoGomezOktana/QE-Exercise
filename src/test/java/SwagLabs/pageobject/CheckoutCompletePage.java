package SwagLabs.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends PageObject {
    @FindBy(className = "complete-header")
    WebElementFacade headerText;

    public void checkConfirmation(){
        String text = headerText.getText();
        Assert.assertEquals("Thank you for your order!",text);
    }

}
