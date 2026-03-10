package com.abc.stepDefinitions;

import java.util.Map;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import com.abc.pageObjects.AccountPage;
import com.abc.pageObjects.BasePage;
import com.abc.pageObjects.HomePage;
import com.abc.pageObjects.RegistrationPage;
import com.abc.utilities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.assertEquals;

public class RegistrationSteps {
    Logger logger = LogManager.getLogger();
    String emailAddress;
    private TestContext context;
    BasePage basePage;
    HomePage homePage;
    RegistrationPage registrationPage;
    AccountPage accountPage;

    public RegistrationSteps(TestContext context, BasePage basePage, HomePage homePage, RegistrationPage registrationPage, AccountPage accountPage) {
        this.context = context;
        this.basePage = basePage;
        this.homePage = homePage;
        this.registrationPage = registrationPage;
        this.accountPage = accountPage;
    }

    @Given("User navigate to register account page")
    public void user_navigate_to_register_account_page() {
        logger.info("Launched application.");
        homePage = new HomePage(context);
        logger.info("Clicked my account.");
        homePage.clickMyaccount();
        logger.info("Clicked login.");
        homePage.clickRegister();
    }

    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registrationPage = new RegistrationPage(context);

        emailAddress = BaseTest.getEmailAddress();
        logger.info("Entered first name.");
        registrationPage.enterFirstname(dataMap.get("firstName"));
        logger.info("Entered last name.");
        registrationPage.enterLastname(dataMap.get("lastName"));
        logger.info("Entered email.");
        registrationPage.enterEmail(emailAddress);
        logger.info("Entered telephone.");
        registrationPage.enterTelephoneNo(dataMap.get("telephone"));
        logger.info("Entered password.");
        registrationPage.enterPassword(dataMap.get("password"));
        logger.info("Entered password again.");
        registrationPage.enterConfirmPassword(dataMap.get("password"));
    }

    @When("User select the privacy policy")
    public void user_select_the_privacy_policy() {
        logger.info("Accepted privacy policy.");
        registrationPage.tickPolicy();
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        logger.info("Clicked continue.");
        registrationPage.clickContinue();
    }

    @Then("User account should get created successfully.")
    public void user_account_should_get_created_successfully() {
        accountPage = new AccountPage(context);
        String actualMsg = accountPage.isAccountCreated();
        String expectedMsg = "Your Account Has Been Created!";
        assertEquals(actualMsg, expectedMsg);
        logger.info(emailAddress);
        logger.info(actualMsg);
        basePage.scrollToHeight();
        logger.info("Clicked logout.");
        accountPage.clickLogout();
    }
}
