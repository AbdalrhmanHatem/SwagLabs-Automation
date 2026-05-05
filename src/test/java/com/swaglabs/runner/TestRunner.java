package com.swaglabs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.swaglabs.steps", "com.swaglabs.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}