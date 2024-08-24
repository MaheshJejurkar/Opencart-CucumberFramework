package stepsdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;

public class RegistrationSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountPage ap;
	RegistrationPage rp;

	@Given("user navigate to register account page")
	public void user_navigate_to_register_account_page() throws Exception {
		Thread.sleep(1000);
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyaccount();
		Thread.sleep(1000);
		hp.clickRegister();
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) throws Exception {
		Thread.sleep(1000);
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		rp=new RegistrationPage(BaseClass.getDriver());
		
		rp.enterFirstname(dataMap.get("firstName"));
		rp.enterLastname(dataMap.get("lastName"));
		rp.enterEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		rp.enterTelephoneNo(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmPassword(dataMap.get("password"));
	}

	@When("user select the privacy policy")
	public void user_select_the_privacy_policy() {
		rp.tickPolicy();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() throws Exception {
		Thread.sleep(1000);
		rp.clickContinue();
	}

	@Then("user account should get created successfully.")
	public void user_account_should_get_created_successfully() throws Exception {
			Thread.sleep(1000);
			ap=new AccountPage(BaseClass.getDriver());
			String actualMsg = ap.isAccountCreated();
			String expectedMsg = "Your Account Has Been Created!";
			Assert.assertEquals(expectedMsg, actualMsg);
	}
}
