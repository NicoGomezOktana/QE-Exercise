package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainPage extends PageObject {
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElementFacade menuButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElementFacade productSortSelector;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[contains(text(),'Price (low to high)')]")
    WebElementFacade sortLowToHighOption;

    static String aboutPageLinkXpath = "//a[@id='about_sidebar_link']";
    WebElementFacade aboutPageLink;
    static String resetStateLinkXpath = "//a[@id='reset_sidebar_link']";
    WebElementFacade resetStateLink;

    static String productsAddButtonsXpath = "//button[@class='btn btn_primary btn_small btn_inventory']";
    static List<WebElementFacade> productsAddButtons;



    @FindBy(xpath = "//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']")
    WebElementFacade shoppingCartBadge;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElementFacade shoppingCartLink;

    static String cartItemsXpath="//div[@class='cart_item']";
    static List<WebElementFacade> cartItems;

    static String cartItemNameXpath=".//div[@class='inventory_item_name']";
    static String cartItemDescriptionXpath=".//div[@class='inventory_item_desc']";
    static String cartItemPriceXpath=".//div[@class='inventory_item_price']";
    public void goToAboutPage(){
        menuButton.click();
        aboutPageLink = withTimeoutOf(10, TimeUnit.SECONDS).find(By.xpath(aboutPageLinkXpath));
        aboutPageLink.click();
    }

    public void sortProductsLowToHigh(){
        productSortSelector.click();
        sortLowToHighOption.click();
    }

    public void addMostExpensive(String number_items){
        int itemsToAdd = Integer.parseInt(number_items);
        productsAddButtons = withTimeoutOf(10, TimeUnit.SECONDS).findAll(By.xpath(productsAddButtonsXpath));
        int amountOfProducts = productsAddButtons.size();
        for (int i = amountOfProducts-1; i>=Math.max(amountOfProducts-itemsToAdd, 0); i--){
            productsAddButtons.get(i).click();
        }
    }

    public void checkNumberAtCartBadge(String expectedNumber){//Should Return an error
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
        String amount_loaded = shoppingCartBadge.getText();
        Assert.assertEquals(expectedNumber,amount_loaded);
    }

    public void goToCart(){
        shoppingCartLink.click();
    }

    public void resetAppState(){
        menuButton.click();
        resetStateLink = withTimeoutOf(10, TimeUnit.SECONDS).find(By.xpath(resetStateLinkXpath));
        resetStateLink.click();
    }
}
