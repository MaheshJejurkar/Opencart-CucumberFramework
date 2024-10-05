package stepsdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.BaseClass;

public class LoginSteps {
	
	WebDriver driver;
	
	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	
	@Given("User navigate to login page")
	public void user_navigate_to_login_page() throws Exception {
		BaseClass.getLogger().info("Launched application.");
		homepage = new HomePage(BaseClass.getDriver());

		Thread.sleep(1000);
		BaseClass.getLogger().info("Clicked my account.");
		homepage.clickMyaccount();
		BaseClass.getLogger().info("Clicked login.");
		homepage.clickLogin();
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws Exception {
		Thread.sleep(1000);
		loginpage = new LoginPage(BaseClass.getDriver());
		BaseClass.getLogger().info("Entered email.");
		loginpage.enterEmail(email);
		BaseClass.getLogger().info("Entered password.");
		loginpage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() throws Exception {
		Thread.sleep(1000);
		BaseClass.getLogger().info("Clicked login.");
		loginpage.clickLogin();
	}

	@Then("User should be redirected to the myaccount page")
	public void user_should_be_redirected_to_the_myaccount_page() throws Exception {
		Thread.sleep(1000);
		accountpage = new AccountPage(BaseClass.getDriver());
		boolean result = accountpage.isMyAccountPageExists();
		Assert.assertEquals(true, result);
		BaseClass.getLogger().info("User logged in successfully.");
	}

}
