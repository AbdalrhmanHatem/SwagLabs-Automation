package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrices;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".cart_button")
    private WebElement removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInCart(String itemName) {
        return itemNames.stream()
                .anyMatch(item -> item.getText().equals(itemName));
    }

    public double calculateTotalPrice() {
        return itemPrices.stream()
                .mapToDouble(price -> Double.parseDouble(
                        price.getText().replace("$", "")))
                .sum();
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }

    public void removeFirstItem() {
        click(removeButton);
    }
}