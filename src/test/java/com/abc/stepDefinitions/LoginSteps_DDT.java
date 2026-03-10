package com.abc.stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.*;
import com.abc.pageObjects.AccountPage;
import com.abc.pageObjects.BasePage;
import com.abc.pageObjects.LoginPage;
import com.abc.utilities.DataReader;

public class LoginSteps_DDT {
    Logger logger = LogManager.getLogger();
    private TestContext context;
    BasePage basePage;
    LoginPage loginPage;
    AccountPage accountPage;

    List<HashMap<String, String>> dataList;
    HashMap<String, String> dataMap;

    public LoginSteps_DDT(TestContext context, BasePage basepage, LoginPage loginPage, AccountPage accountPage) {
        this.context = context;
        this.basePage = basePage;
        this.loginPage = loginPage;
        this.accountPage = accountPage;
    }

    @Then("User should be redirected to the my account page by passing email and password with TcNo {string}")
    public void user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_TcNo(String TcNo) {
        basePage = new BasePage(context);
        accountPage = new AccountPage(context);
        loginPage = new LoginPage(context);

        try {
            dataMap = DataReader.data(System.getProperty("user.dir") + "\\testdata\\Opencart_Testdata.xlsx", "Sheet1", TcNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String email = dataMap.get("Username");
        String password = dataMap.get("Password");
        String expectedResult = dataMap.get("Result");

        logger.info("Entered email: " + email);
        loginPage.enterEmail(email);
        logger.info("Entered password: " + password);
        loginPage.enterPassword(password);
        logger.info("Clicked login: " + expectedResult);
        loginPage.clickLogin();

        try {
            boolean pageStatus = accountPage.isMyAccountPageExists();
            if (expectedResult.equalsIgnoreCase("Valid")) {
                if (pageStatus == true) {
                    logger.info(expectedResult + " user: " + email);
                    logger.info("User logged in successfully.");
                    basePage.scrollToHeight();
                    logger.info("Clicked logout.");
                    accountPage.clickLogout();
                    Assert.assertTrue(pageStatus);
                } else {
                    logger.info(expectedResult + " user: " + email);
                    logger.info("User login failed.");
                    Assert.assertTrue(pageStatus);
                }
            }
            if (expectedResult.equalsIgnoreCase("Invalid")) {
                if (pageStatus == true) {
                    logger.info(expectedResult + " user: " + email);
                    logger.info("User logged in.");
                    basePage.scrollToHeight();
                    logger.info("Clicked logout.");
                    accountPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    logger.info(expectedResult + " user: " + email);
                    logger.info("User login failed.");
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
