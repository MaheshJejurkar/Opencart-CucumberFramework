package com.abc.pageObjects;

import com.abc.stepDefinitions.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	JavascriptExecutor javascriptExecutor;

	public BasePage(TestContext context) {
		this.driver = context.getDriver();
		PageFactory.initElements(driver, this);
	}

	public JavascriptExecutor getJavaScriptExecutor() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor;
	}

	public void scrollToHeight() {
		getJavaScriptExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
