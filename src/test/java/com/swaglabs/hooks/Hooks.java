package com.swaglabs.hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        WebDriverManager.chromedriver().setup();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordImport");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-first-run");
        options.addArguments("--disable-default-apps");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        ExtentTest extentTest = ExtentReportManager.getInstance()
                .createTest(scenario.getName());
        ExtentReportManager.setTest(extentTest);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.getTest().log(Status.FAIL,
                    "Scenario Failed: " + scenario.getName());
        } else {
            ExtentReportManager.getTest().log(Status.PASS,
                    "Scenario Passed: " + scenario.getName());
        }
        ExtentReportManager.flushReport();

        if (driver != null) {
            driver.quit();
        }
    }
}