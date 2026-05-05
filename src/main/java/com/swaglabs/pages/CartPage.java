package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {

    // قائمة بأسماء المنتجات في الـ cart
    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemNames;

    // قائمة بأسعار المنتجات في الـ cart
    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrices;

    // زرار Continue Shopping للرجوع لصفحة المنتجات
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    // زرار الـ Checkout
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    // زرار Remove لأول منتج
    @FindBy(css = ".cart_button")
    private WebElement removeButton;

    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Method — بترجع أسماء كل المنتجات في الـ cart
    public boolean isItemInCart(String itemName) {
        return itemNames.stream()
                .anyMatch(item -> item.getText().equals(itemName));
    }

    // Method — بتحسب مجموع الأسعار
    public double calculateTotalPrice() {
        return itemPrices.stream()
                .mapToDouble(price -> Double.parseDouble(
                        price.getText().replace("$", "")))
                .sum();
    }

    // Method — بترجع للصفحة الرئيسية
    public void continueShopping() {
        click(continueShoppingButton);
    }

    // Method — بتروح للـ Checkout
    public void proceedToCheckout() {
        click(checkoutButton);
    }

    // Method — بتشيل أول منتج من الـ cart
    public void removeFirstItem() {
        click(removeButton);
    }
}