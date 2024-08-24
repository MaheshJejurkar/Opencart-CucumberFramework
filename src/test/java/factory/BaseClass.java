package factory;

import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Logger logger;
	static Properties properties;
	public static ChromeOptions chromeoptions;


	public static WebDriver initializeBrowser() throws Exception {

		properties = getProperties();
		String executionEnv = properties.getProperty("ExecutionEnv").toLowerCase();
		String browser = properties.getProperty("Browser").toLowerCase();
		String os = properties.getProperty("OS").toLowerCase();

		if (executionEnv.equals("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			switch (os) {
			case "windows": capabilities.setPlatform(Platform.WIN11); break;
			case "mac" : capabilities.setPlatform(Platform.MAC); break;
			case "linux" : capabilities.setPlatform(Platform.LINUX); break;
			default : System.out.println("No match to OS."); return null;
			}
			
			switch (browser) {
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "firefox" : capabilities.setBrowserName("firefox"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default : System.out.println("No match to browser."); return null;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}else 
			if (executionEnv.equals("local")) {
			switch (browser) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default: System.out.println("No match to broser."); return null;
		  }
		}else {
			System.out.println("Invalid environment set.");
			return null;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Properties getProperties() throws Exception {
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		properties = new Properties();
		properties.load(file);
		return properties;
	}
	
	public static Logger getLogger() {
		logger = LogManager.getLogger(BaseClass.class);
		return logger;
	}

	public static String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public static String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public static String randomAlphaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring + "." + generatednumber);
	}
}
