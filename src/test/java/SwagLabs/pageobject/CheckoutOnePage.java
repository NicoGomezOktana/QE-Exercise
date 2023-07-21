package SwagLabs.pageobject;

import jxl.common.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CheckoutOnePage extends PageObject {
    @FindBy(id = "first-name")
    WebElementFacade firstNameInput;
    @FindBy(id = "last-name")
    WebElementFacade lastNameInput;
    @FindBy(id = "postal-code")
    WebElementFacade postalCodeInput;
    @FindBy(id = "continue")
    WebElementFacade continueButton;
    static String errorContainerClassName= "error-message-container";
    WebElementFacade errorContainer;
    public void fillData(String firstName, String lastName, String zipCode){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(zipCode);
    }
    public void continueCheckout(){
        continueButton.click();
    }
    public void checkErrorMessage(){
        errorContainer = withTimeoutOf(10, TimeUnit.SECONDS).find(By.className(errorContainerClassName));
        Assert.verify(errorContainer.isDisplayed());
    }
    public void scrollToTop(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
    }


}
