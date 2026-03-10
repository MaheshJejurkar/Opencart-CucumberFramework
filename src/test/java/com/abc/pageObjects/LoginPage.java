package com.abc.pageObjects;

import com.abc.stepDefinitions.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(TestContext context) {
        this.driver = context.getDriver();
		PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btn_login;

    public void enterEmail(String email) {
        txt_email.sendKeys(email);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickLogin() {
        btn_login.click();
    }
}
