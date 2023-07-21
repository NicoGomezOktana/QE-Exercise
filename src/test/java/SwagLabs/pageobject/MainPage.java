package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class MainPage extends PageObject {
    @FindBy(id="react-burger-menu-btn")
    WebElementFacade menuButton;

    @FindBy(className = "product_sort_container")
    WebElementFacade productSortSelector;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[contains(text(),'Price (low to high)')]")
    WebElementFacade sortLowToHighOption;

    static String aboutPageLinkId = "about_sidebar_link";
    WebElementFacade aboutPageLink;
    static String resetStateLinkId= "reset_sidebar_link";
    WebElementFacade resetStateLink;

    static String productsAddButtonsClass = "btn_inventory";
    static List<WebElementFacade> productsAddButtons;

    @FindBy(className = "shopping_cart_badge")
    WebElementFacade shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElementFacade shoppingCartLink;

    public void goToAboutPage(){
        menuButton.click();
        aboutPageLink = withTimeoutOf(Duration.ofSeconds(10)).find(By.id(aboutPageLinkId));
        aboutPageLink.click();
    }
    public void checkPage(){
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(currentUrl,expectedUrl);

        String currentTitle = getDriver().getTitle();
        String expectedMainPageTitle = "Swag Labs";
        Assert.assertEquals(currentTitle,expectedMainPageTitle);
    }
    public void sortProductsLowToHigh(){
        productSortSelector.click();
        sortLowToHighOption.click();
    }

    public void addMostExpensive(String number_items){
        int itemsToAdd = Integer.parseInt(number_items);
        productsAddButtons = withTimeoutOf(Duration.ofSeconds(10)).findAll(By.className(productsAddButtonsClass));
        int amountOfProducts = productsAddButtons.size();
        for (int i = amountOfProducts-1; i>=Math.max(amountOfProducts-itemsToAdd, 0); i--){
            productsAddButtons.get(i).click();
        }
    }
    public void scrollToTop() throws InterruptedException {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
        Thread.sleep(50);//Wait for the window to be scrolled before screenshot

    }
    public void checkNumberAtCartBadge(String expectedNumber){//Should Return an error
        String amount_loaded = shoppingCartBadge.getText();
        Assert.assertEquals(expectedNumber,amount_loaded);
    }

    public void goToCart(){
        shoppingCartLink.click();
    }

    public void resetAppState(){
        menuButton.click();
        resetStateLink = withTimeoutOf(Duration.ofSeconds(10)).find(By.id(resetStateLinkId));
        resetStateLink.click();
    }
}
