package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addBoltTShirtButton;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void addBackpackToCart() {
        click(addBackpackButton);
    }

    public void addBoltTShirtToCart() {
        click(addBoltTShirtButton);
    }

    public void goToCart() {
        click(cartIcon);
    }

    public void logout() {
        click(menuButton);
        click(logoutButton);
    }
}