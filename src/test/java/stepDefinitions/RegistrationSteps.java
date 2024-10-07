package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utilities.BaseClass;

public class RegistrationSteps {
	WebDriver driver;

	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	RegistrationPage registrationpage;
	
	String emailAddress;

	@Given("User navigate to register account page")
	public void user_navigate_to_register_account_page() throws Exception {
		BaseClass.getLogger().info("Launched application.");
		homepage = new HomePage(BaseClass.getDriver());
		BaseClass.getLogger().info("Clicked my account.");
		homepage.clickMyaccount();
		BaseClass.getLogger().info("Clicked login.");
		homepage.clickRegister();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) throws Exception {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registrationpage = new RegistrationPage(BaseClass.getDriver());

		emailAddress = BaseClass.getEmailAddress();
		BaseClass.getLogger().info("Entered first name.");
		registrationpage.enterFirstname(dataMap.get("firstName"));
		BaseClass.getLogger().info("Entered last name.");
		registrationpage.enterLastname(dataMap.get("lastName"));
		BaseClass.getLogger().info("Entered email.");
		registrationpage.enterEmail(emailAddress);
		BaseClass.getLogger().info("Entered telephone.");
		registrationpage.enterTelephoneNo(dataMap.get("telephone"));
		BaseClass.getLogger().info("Entered password.");
		registrationpage.enterPassword(dataMap.get("password"));
		BaseClass.getLogger().info("Entered password again.");
		registrationpage.enterConfirmPassword(dataMap.get("password"));
	}

	@When("User select the privacy policy")
	public void user_select_the_privacy_policy() {
		BaseClass.getLogger().info("Accepted privacy policy.");
		registrationpage.tickPolicy();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() throws Exception {
		BaseClass.getLogger().info("Clicked continue.");
		registrationpage.clickContinue();
	}

	@Then("User account should get created successfully.")
	public void user_account_should_get_created_successfully() throws Exception {
		accountpage = new AccountPage(BaseClass.getDriver());
		String actualMsg = accountpage.isAccountCreated();
		String expectedMsg = "Your Account Has Been Created!";
		Assert.assertEquals(expectedMsg, actualMsg);
		BaseClass.getLogger().info(emailAddress);
		BaseClass.getLogger().info(actualMsg);
		BaseClass.scrollToHeight();
		BaseClass.getLogger().info("Clicked logout.");
		accountpage.clickLogout();
	}
}
