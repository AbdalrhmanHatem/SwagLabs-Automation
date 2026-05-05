package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    // Step One — حقول البيانات
    @FindBy(css = "[data-test='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "[data-test='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "[data-test='postalCode']")
    private WebElement postalCodeField;

    @FindBy(css = "[data-test='continue']")
    private WebElement continueButton;

    // رسالة الـ error
    @FindBy(css = ".error-message-container h3")
    private WebElement errorMessage;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Method — بتملي بيانات الـ Checkout
    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);
        click(continueButton);
    }

    // Method — بتضغط Finish بـ dynamic find
    public void finishCheckout() {
        WebElement finishButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("finish")));
        finishButton.click();
    }

    // Method — بترجع رسالة التأكيد بـ dynamic find
    public String getConfirmationMessage() {
        WebElement confirmation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".complete-header")));
        return confirmation.getText();
    }

    // Method — بترجع رسالة الـ Error
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    // Method — بتضغط Continue من غير ما تملي حاجة
    public void clickContinueWithoutData() {
        click(continueButton);
    }
}