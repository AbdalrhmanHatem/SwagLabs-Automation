package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    // الـ WebDriver اللي هيتشارك في كل الـ pages
    protected WebDriver driver;

    // الـ WebDriverWait للانتظار لحد ما العناصر تظهر
    protected WebDriverWait wait;

    // Constructor — بياخد الـ driver ويجهز الـ page
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // بيعمل initialize للـ WebElements في الـ page
        PageFactory.initElements(driver, this);
    }

    // Method مشتركة — بتستنى العنصر يبقى clickable وبعدين بتضغط عليه
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Method مشتركة — بتكتب في أي field
    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    // Method مشتركة — بتجيب النص من أي عنصر
    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}