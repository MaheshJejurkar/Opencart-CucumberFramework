package stepsdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import utilities.BaseClass;

public class RegistrationSteps {
	WebDriver driver;

	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	RegistrationPage registrationpage;

	@Given("User navigate to register account page")
	public void user_navigate_to_register_account_page() throws Exception {
		Thread.sleep(1000);
		BaseClass.getLogger().info("Launched application.");
		homepage = new HomePage(BaseClass.getDriver());
		BaseClass.getLogger().info("Clicked my account.");
		homepage.clickMyaccount();
		Thread.sleep(1000);
		BaseClass.getLogger().info("Clicked login.");
		homepage.clickRegister();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) throws Exception {
		Thread.sleep(1000);

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registrationpage = new RegistrationPage(BaseClass.getDriver());

		BaseClass.getLogger().info("Entered first name.");
		registrationpage.enterFirstname(dataMap.get("firstName"));
		BaseClass.getLogger().info("Entered last name.");
		registrationpage.enterLastname(dataMap.get("lastName"));
		BaseClass.getLogger().info("Entered email.");
		registrationpage.enterEmail(BaseClass.randomAlphaNumeric() + "@gmail.com");
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
		Thread.sleep(1000);
		BaseClass.getLogger().info("Clicked continue.");
		registrationpage.clickContinue();
	}

	@Then("User account should get created successfully.")
	public void user_account_should_get_created_successfully() throws Exception {
		Thread.sleep(1000);
		accountpage = new AccountPage(BaseClass.getDriver());
		String actualMsg = accountpage.isAccountCreated();
		String expectedMsg = "Your Account Has Been Created!";
		Assert.assertEquals(expectedMsg, actualMsg);
		BaseClass.getLogger().info(actualMsg);
		Thread.sleep(2000);
		BaseClass.scrollToHeight();
		BaseClass.getLogger().info("Clicked logout.");
		accountpage.clickLogout();
	}
}
