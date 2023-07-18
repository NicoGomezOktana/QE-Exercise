package SwagLabs.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class CheckoutOnePage extends PageObject {
    @FindBy(xpath = "//input[@id='first-name']")
    WebElementFacade firstNameInput;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElementFacade lastNameInput;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElementFacade postalCodeInput;
    @FindBy(xpath = "//input[@id='continue']")
    WebElementFacade continueButton;

    public void fillData(String firstName, String lastName, String zipCode){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(zipCode);

    }
    public void continueCheckout(){
        continueButton.click();
    }
    public void scrollToTop(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
    }


}
