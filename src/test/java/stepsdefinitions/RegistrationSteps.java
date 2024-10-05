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

	@Given("user navigate to register account page")
	public void user_navigate_to_register_account_page() throws Exception {
		Thread.sleep(1000);
		homepage = new HomePage(BaseClass.getDriver());
		homepage.clickMyaccount();
		Thread.sleep(1000);
		homepage.clickRegister();
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) throws Exception {
		Thread.sleep(1000);

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registrationpage = new RegistrationPage(BaseClass.getDriver());

		registrationpage.enterFirstname(dataMap.get("firstName"));
		registrationpage.enterLastname(dataMap.get("lastName"));
		registrationpage.enterEmail(BaseClass.randomAlphaNumeric() + "@gmail.com");
		registrationpage.enterTelephoneNo(dataMap.get("telephone"));
		registrationpage.enterPassword(dataMap.get("password"));
		registrationpage.enterConfirmPassword(dataMap.get("password"));
	}

	@When("user select the privacy policy")
	public void user_select_the_privacy_policy() {
		registrationpage.tickPolicy();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() throws Exception {
		Thread.sleep(1000);
		registrationpage.clickContinue();
	}

	@Then("user account should get created successfully.")
	public void user_account_should_get_created_successfully() throws Exception {
		Thread.sleep(1000);
		accountpage = new AccountPage(BaseClass.getDriver());
		String actualMsg = accountpage.isAccountCreated();
		String expectedMsg = "Your Account Has Been Created!";
		Assert.assertEquals(expectedMsg, actualMsg);
	}
}
