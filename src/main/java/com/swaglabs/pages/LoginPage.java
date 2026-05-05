package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // العناصر الموجودة على صفحة الـ Login
    // بنستخدم @FindBy عشان PageFactory يلاقي العنصر تلقائياً

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Method — بتفتح صفحة الـ Login
    public void navigateTo() {
        driver.get("https://www.saucedemo.com");
    }

    // Method — بتعمل Login بـ username و password
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    // Method — بترجع رسالة الـ Error لو فيه
    public String getErrorMessage() {
        return getText(errorMessage);
    }
}