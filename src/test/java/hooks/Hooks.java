package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;

public class Hooks {
	WebDriver driver;
	Properties properties;

	@Before
	public void setup() throws Exception {

		Runtime.getRuntime().exec("cmd /c start_dockergrid.bat");
		Thread.sleep(20000);

		properties = BaseClass.getProperties();
		driver = BaseClass.initializeBrowser();
		driver.get(properties.getProperty("tutorialsninja"));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();

		Runtime.getRuntime().exec("cmd /c stop_dockergrid.bat");
		Thread.sleep(20000);
		//Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] sourceFile = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceFile, "image/png", scenario.getName());
		}
	}
}
