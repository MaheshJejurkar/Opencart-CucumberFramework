package com.abc;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String EDGE = "edge";
    private WebDriver driver;
    private Properties properties;

    public WebDriver initializeBrowser() throws Exception {
        properties = ConfigurationManager.getProperties();
        String os = getProperty("OS");
        String environment = getProperty("Environment");
        String browser = getProperty("Browser");

        if (environment.equals("remote")) {
            driver = initializeRemoteBrowser(os, browser);
        } else if (environment.equals("local")) {
            driver = initializeLocalBrowser(browser);
        } else {
            throw new IllegalArgumentException("Invalid environment: " + environment +
                    ". Expected 'local' or 'remote'");
        }

        configureDriver();
        return driver;
    }

    private WebDriver initializeRemoteBrowser(String os, String browser) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(getPlatform(os));
        capabilities.setBrowserName(getBrowserName(browser));
        return new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
    }

    private WebDriver initializeLocalBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case CHROME:
                return new ChromeDriver();
            case EDGE:
                return new EdgeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser +
                        ". Supported browsers: chrome, firefox, edge");
        }
    }

    private Platform getPlatform(String os) {
        switch (os.toLowerCase()) {
            case "windows":
                return Platform.WIN11;
            case "mac":
                return Platform.MAC;
            case "linux":
                return Platform.LINUX;
            default:
                throw new IllegalArgumentException("Unsupported OS: " + os +
                        ". Supported OS: windows, mac, linux");
        }
    }

    private String getBrowserName(String browser) {
        switch (browser.toLowerCase()) {
            case CHROME:
                return CHROME;
            case FIREFOX:
                return FIREFOX;
            case EDGE:
                return "MicrosoftEdge";
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser +
                        ". Supported browsers: chrome, firefox, edge");
        }
    }

    private String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Property '" + key + "' not found or is empty in configuration");
        }
        return value.toLowerCase();
    }

    private void configureDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
