package SwagLabs.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends PageObject {
    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;
    static String cartItemsClass="cart_item";
    static List<WebElementFacade> cartItems;

    static String cartItemNameClass="inventory_item_name";
    static String cartItemDescriptionClass="inventory_item_desc";
    static String cartItemPriceClass="inventory_item_price";

    public void storeCartItemsInfo(){
        cartItems = withTimeoutOf(Duration.ofSeconds(10)).findAll(By.className(cartItemsClass));

        for (WebElementFacade cartItem: cartItems){
            String itemName= cartItem.findElement(By.className(cartItemNameClass)).getText();
            String itemDescription = cartItem.findElement(By.className(cartItemDescriptionClass)).getText();
            String itemPrice = cartItem.findElement(By.className(cartItemPriceClass)).getText();

            String details = itemName +"\n"+ itemDescription + "\n" + itemPrice+"\n";
            Serenity.recordReportData().withTitle("Details of Cart Item").andContents(details);
        }
    }
    public void goToCheckout(){
        checkoutButton.click();
    }
}
