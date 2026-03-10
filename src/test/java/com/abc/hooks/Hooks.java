package com.abc.hooks;

import java.util.Properties;

import com.abc.ConfigurationManager;
import com.abc.DriverManager;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.abc.stepDefinitions.TestContext;

public class Hooks {
    private final TestContext context;
    Properties properties;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setup(Scenario scenario) throws Exception {
//		Runtime.getRuntime().exec("cmd /c start_dockergrid.bat");
//		Thread.sleep(20000);
        ExtentCucumberAdapter.addTestStepLog("Scenario Started: " + scenario.getName());

        properties = ConfigurationManager.getProperties();
        context.setDriver(new DriverManager().initializeBrowser());
        context.getDriver().get(properties.getProperty("tutorialsninja"));
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
//		Runtime.getRuntime().exec("cmd /c stop_dockergrid.bat");
//		Thread.sleep(20000);
//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

        if (scenario.isFailed()) {
            ExtentCucumberAdapter.addTestStepLog("Scenario Failed: " + scenario.getName());
        } else {
            ExtentCucumberAdapter.addTestStepLog("Scenario Passed: " + scenario.getName());
        }

        ExtentCucumberAdapter.addTestStepLog("Scenario Finished: " + scenario.getName());
        context.getDriver().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) context.getDriver();
            byte[] sourceFile = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourceFile, "image/png", scenario.getName());
        }
    }
}
