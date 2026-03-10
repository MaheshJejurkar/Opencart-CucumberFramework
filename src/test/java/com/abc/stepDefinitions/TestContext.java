package com.abc.stepDefinitions;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private WebDriver driver;

    private final Map<String, Object> testData = new HashMap<>();

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Map<String, Object> getTestData() {
        return testData;
    }
}
