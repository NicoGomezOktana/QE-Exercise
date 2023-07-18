package SwagLabs.steps;

import SwagLabs.pageobject.*;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

//Realiza las interacciones en la página
//tendriamos que tener una clase con los tasks y otra con questions?
public class SwagLabsUser extends ScenarioActor {
    String actor;

    @Steps(shared=true)
    LoginPage loginPage;
    MainPage mainPage;
    AboutPage aboutPage;
    CartPage cartPage;
    CheckoutOnePage checkoutOnePage;
    CheckoutTwoPage checkoutTwoPage;
    CheckoutCompletePage checkoutCompletePage;


    public void navigateToLogin(){
        loginPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        loginPage.open();
    }
    public void login(String username, String password){
        loginPage.loginAsUser(username,password);

    }

    public void goToAbout(){
        mainPage.goToAboutPage();

    }
    public void goBackFromAbout(){
        aboutPage.goBack();
    }

    public void sortProductsLowToHigh(){
        mainPage.sortProductsLowToHigh();
    }
    public void addMostExpensive(String number_items){
        mainPage.addMostExpensive(number_items);
    }
    public void checkNumberAtCartBadge(String expectedNumber){
        mainPage.checkNumberAtCartBadge(expectedNumber);
    }
    public void resetAppState(){
        mainPage.resetAppState();
    }
    public void goToCart(){
        mainPage.goToCart();
        cartPage.storeCartItemsInfo();
    }
    public void goToCheckout(){
        cartPage.goToCheckout();
        checkoutOnePage.scrollToTop();
    }
    public void fillCheckoutData(String firstName, String lastName, String zipCode){
        checkoutOnePage.fillData(firstName,lastName,zipCode);
    }
    public void continueCheckout(){
        checkoutOnePage.continueCheckout();
    }
    public void checkPurchaseData(){
        checkoutTwoPage.checkPrices();

    }
    public void finishPurchase(){
        checkoutTwoPage.finishPurchase();
    }
    public void checkSuccess(){
        checkoutCompletePage.checkConfirmation();
    }
}
