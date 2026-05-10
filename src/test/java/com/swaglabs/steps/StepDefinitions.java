package com.swaglabs.steps;

import com.swaglabs.hooks.Hooks;
import com.swaglabs.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class StepDefinitions {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    private double expectedTotal;

    private void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(Hooks.driver);
        productsPage = new ProductsPage(Hooks.driver);
        cartPage = new CartPage(Hooks.driver);
        checkoutPage = new CheckoutPage(Hooks.driver);
        loginPage.navigateTo();
        delay();
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
        delay();
    }

    @When("the user logs in with invalid credentials")
    public void the_user_logs_in_with_invalid_credentials() {
        loginPage.login("wrong_user", "wrong_pass");
        delay();
    }

    @When("the user logs in as locked out user")
    public void the_user_logs_in_as_locked_out_user() {
        loginPage.login("locked_out_user", "secret_sauce");
        delay();
    }

    @Then("the user should see the Products page")
    public void the_user_should_see_the_products_page() {
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
        delay();
    }

    @Then("an error message should appear")
    public void an_error_message_should_appear() {
        Assert.assertTrue(loginPage.getErrorMessage().contains(
                "Username and password do not match"));
        delay();
    }

    @Then("a locked out error message should appear")
    public void a_locked_out_error_message_should_appear() {
        Assert.assertTrue(loginPage.getErrorMessage().contains(
                "Sorry, this user has been locked out"));
        delay();
    }

    @When("the user adds Sauce Labs Backpack to cart")
    public void the_user_adds_backpack_to_cart() {
        productsPage.addBackpackToCart();
        delay();
    }

    @When("the user adds Sauce Labs Bolt T-Shirt to cart")
    public void the_user_adds_bolt_tshirt_to_cart() {
        productsPage.addBoltTShirtToCart();
        delay();
    }

    @When("the user goes to cart")
    public void the_user_goes_to_cart() {
        productsPage.goToCart();
        delay();
    }

    @Then("Sauce Labs Backpack should be in the cart")
    public void backpack_should_be_in_cart() {
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));
        delay();
    }

    @Then("Sauce Labs Bolt T-Shirt should be in the cart")
    public void bolt_tshirt_should_be_in_cart() {
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Bolt T-Shirt"));
        delay();
    }

    @When("the user continues shopping")
    public void the_user_continues_shopping() {
        cartPage.continueShopping();
        delay();
    }

    @Then("the total price should be correct")
    public void the_total_price_should_be_correct() {
        expectedTotal = cartPage.calculateTotalPrice();
        Assert.assertTrue(expectedTotal > 0);
        delay();
    }

    @When("the user removes the item from cart")
    public void the_user_removes_item_from_cart() {
        cartPage.removeFirstItem();
        delay();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        Assert.assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
        delay();
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        cartPage.proceedToCheckout();
        delay();
    }

    @When("the user fills checkout info with valid data")
    public void the_user_fills_checkout_info() {
        checkoutPage.fillCheckoutInfo("Ahmed", "Mohamed", "12345");
        delay();
    }

    @When("the user finishes the order")
    public void the_user_finishes_the_order() {
        checkoutPage.finishCheckout();
        delay();
    }

    @Then("the order should be confirmed")
    public void the_order_should_be_confirmed() {
        Assert.assertEquals(checkoutPage.getConfirmationMessage(),
                "Thank you for your order!");
        delay();
    }

    @When("the user clicks continue without filling data")
    public void the_user_clicks_continue_without_filling_data() {
        checkoutPage.clickContinueWithoutData();
        delay();
    }

    @Then("a missing info error message should appear")
    public void a_missing_info_error_message_should_appear() {
        Assert.assertTrue(checkoutPage.getErrorMessage().contains(
                "First Name is required"));
        delay();
    }

    @When("the user logs out")
    public void the_user_logs_out() {
        productsPage.logout();
        delay();
    }

    @Then("the user should be on the login page")
    public void the_user_should_be_on_the_login_page() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(
                "saucedemo.com"));
        delay();
    }
}