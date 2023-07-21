package SwagLabs.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutTwoPage extends PageObject {
    static String pricesClass="inventory_item_price";
    static List<WebElementFacade> priceTags;
    @FindBy(xpath = "//div[contains(text(),'Payment Information')]//following::div[@class='summary_value_label']")
    WebElementFacade paymentInfoLabel;
    @FindBy(xpath = "//div[contains(text(),'Shipping Information')]//following::div[@class='summary_value_label']")
    WebElementFacade shippingInfoLabel;

    @FindBy(className = "summary_subtotal_label")
    WebElementFacade subtotalInfoLabel;
    @FindBy(className = "summary_tax_label")
    WebElementFacade taxInfoLabel;
    @FindBy(className = "summary_total_label")
    WebElementFacade totalInfoLabel;

    @FindBy(id = "finish")
    WebElementFacade finishButton;

    public void checkPrices(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        priceTags= withTimeoutOf(Duration.ofSeconds(10)).findAll(By.className(pricesClass));
        Double subtotalPriceSum = (double)0;
        for (WebElementFacade priceTag: priceTags){
            String priceString = priceTag.getText().replace("$",""); //Verify if this is correct, or split by $
            Double itemPrice = Double.parseDouble(priceString);
            subtotalPriceSum += itemPrice;
        }
        String subTotalPriceSumString = String.valueOf(subtotalPriceSum);
        String subtotalPriceLabelString =  subtotalInfoLabel.getText().split("\\$",2)[1];
        Assert.assertEquals(subtotalPriceLabelString,subTotalPriceSumString);

        report();
    }

    public void finishPurchase(){
        finishButton.click();
    }
    private void report(){
        String paymentInfoDetails = "Payment Info: "+paymentInfoLabel.getText();
        String shippingInfoDetails = "Shipping Info: "+shippingInfoLabel.getText();
        String priceInfoDetails = "Price Total: \n Item Total: " +subtotalInfoLabel.getText()+"\n Tax: "+taxInfoLabel.getText();
        String totalDetails = "Total: "+totalInfoLabel.getText();
        String details = paymentInfoDetails +"\n"+ shippingInfoDetails + "\n" + priceInfoDetails+"\n"+totalDetails+"\n";
        Serenity.recordReportData().withTitle("Purchase details").andContents(details);
    }



}
