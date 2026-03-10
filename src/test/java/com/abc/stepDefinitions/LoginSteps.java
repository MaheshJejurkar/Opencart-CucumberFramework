package com.abc.stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.abc.pageObjects.AccountPage;
import com.abc.pageObjects.BasePage;
import com.abc.pageObjects.HomePage;
import com.abc.pageObjects.LoginPage;

public class LoginSteps {
    Logger logger = LogManager.getLogger();
    String emailAddress;
    private TestContext context;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    BasePage basePage;

    public LoginSteps(TestContext context, HomePage homePage, LoginPage loginPage, AccountPage accountPage, BasePage basePage) {
        this.context = context;
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.accountPage = accountPage;
        this.basePage = basePage;
    }

    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {
        logger.info("Launched application.");
        homePage = new HomePage(context);
        logger.info("Clicked my account link.");
        homePage.clickMyaccount();
        logger.info("Clicked login link.");
        homePage.clickLogin();
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        emailAddress = email;
        loginPage = new LoginPage(context);
        logger.info("Entered email.");
        loginPage.enterEmail(email);
        logger.info("Entered password.");
        loginPage.enterPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        logger.info("Clicked login.");
        loginPage.clickLogin();
    }

    @Then("User should be redirected to my account page")
    public void user_should_be_redirected_to_my_account_page() throws Exception {
        accountPage = new AccountPage(context);
        boolean result = accountPage.isMyAccountPageExists();
        Assert.assertTrue(result);
        logger.info(emailAddress);
        logger.info("User logged in successfully.");
        Thread.sleep(1000);
        basePage = new BasePage(context);
        basePage.scrollToHeight();
        logger.info("Clicked logout.");
        accountPage.clickLogout();
    }
}
