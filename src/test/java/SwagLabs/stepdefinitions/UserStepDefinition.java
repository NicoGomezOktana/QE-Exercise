package SwagLabs.stepdefinitions;

import SwagLabs.steps.SwagLabsUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserStepDefinition {
    @Steps(shared = true)

    SwagLabsUser user;

    @Given("^User navigates to https://www.saucedemo.com/$")
    public void userNavigateToPage(){
        user.navigateToLogin();
        Serenity.takeScreenshot();
    }


    @And("^logs in as a Standard User$")
    public void userLogin(){
        user.login("standard_user","secret_sauce");
        Serenity.takeScreenshot();
    }

    @And("^User goes to About Page$")
    public void goToAboutPage(){
        user.goToAbout();
        Serenity.takeScreenshot();
    }

    @And("^User goes back to Product Page$")
    public void goBackToProductPage(){
        user.goBackFromAbout();
        Serenity.takeScreenshot();
    }

    @Given("^User sorts the product from low to high price$")
    public void sortLowToHigh(){
        user.sortProductsLowToHigh();
        Serenity.takeScreenshot();
    }

    @And("^User adds the (.*) most expensive products to the cart$")
    public void addProducts(String number_items){
        user.addMostExpensive(number_items);
        Serenity.takeScreenshot();
    }

    @Then("^The top right section displays the number (.*)$")
    public void checkCartBadge(String number_items){
        user.checkNumberAtCartBadge(number_items);
        Serenity.takeScreenshot();
        user.resetAppState();
    }

    @And("^User goes to Shopping Cart$")
    public void goToCart(){
        user.goToCart();
        Serenity.takeScreenshot();
    }

    @And("^User Goes to Checkout$")
    public void goToCheckout(){
        user.goToCheckout();
        Serenity.takeScreenshot();
    }

    @And("^User fills personal data$")
    public void fillCheckoutData(){
        user.fillCheckoutData("First", "Last", "12345");
        Serenity.takeScreenshot();
        user.continueCheckout();
    }
    @And("^User checks purchase and finishes the purchase$")
    public void checkPurchaseDataAndFinish(){
        user.checkPurchaseData();
        Serenity.takeScreenshot();
        user.finishPurchase();
    }

    @Then("^A success message is displayed$")
    public void checkSuccess(){
        user.checkSuccess();
        Serenity.takeScreenshot();
    }
}
