package SwagLabs.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends PageObject {
    @FindBy(xpath = "//button[@id='checkout']")
    WebElementFacade checkoutButton;
    static String cartItemsXpath="//div[@class='cart_item']";
    static List<WebElementFacade> cartItems;

    static String cartItemNameXpath=".//div[@class='inventory_item_name']";
    static String cartItemDescriptionXpath=".//div[@class='inventory_item_desc']";
    static String cartItemPriceXpath=".//div[@class='inventory_item_price']";

    public void storeCartItemsInfo(){
        cartItems = withTimeoutOf(10, TimeUnit.SECONDS).findAll(By.xpath(cartItemsXpath));
        for (WebElementFacade cartItem: cartItems){
            String itemName= cartItem.findElement(By.xpath(cartItemNameXpath)).getText();
            String itemDescription = cartItem.findElement(By.xpath(cartItemDescriptionXpath)).getText();
            String itemPrice = cartItem.findElement(By.xpath(cartItemPriceXpath)).getText();

            String details = itemName +"\n"+ itemDescription + "\n" + itemPrice+"\n";
            Serenity.recordReportData().withTitle("Details of Cart Item").andContents(details);
        }
    }
    public void goToCheckout(){
        checkoutButton.click();
    }
}
