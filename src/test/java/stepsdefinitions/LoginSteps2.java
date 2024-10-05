package stepsdefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.DataReader;

public class LoginSteps2 {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountPage ap;
	
	List<HashMap<String, String>> datamap;
	
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() throws Exception {
		BaseClass.getLogger().info("Launched application.");
		hp=new HomePage(BaseClass.getDriver());
		
		Thread.sleep(1000);
		BaseClass.getLogger().info("Clicked my account.");
		hp.clickMyaccount();
		BaseClass.getLogger().info("Clicked login.");
		hp.clickLogin();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws Exception {
		Thread.sleep(1000);
		lp=new LoginPage(BaseClass.getDriver());
		BaseClass.getLogger().info("Entered email.");
		lp.enterEmail(email);
		BaseClass.getLogger().info("Entered password.");
		lp.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() throws Exception {
		Thread.sleep(1000);
		BaseClass.getLogger().info("Clicked login.");
		lp.clickLogin();
	}

	@Then("user should be redirected to the myaccount page")
	public void user_should_be_redirected_to_the_myaccount_page() throws Exception {
		Thread.sleep(1000);
		ap=new AccountPage(BaseClass.getDriver());
		boolean result = ap.isMyAccountPageExists();
		Assert.assertEquals(true, result);
		BaseClass.getLogger().info("User logged in successfully.");
	}
	
	@Then("user should be redirected to the myaccount page by passing email and password with excel row {string}")
	public void user_should_be_redirected_to_the_myaccount_page_by_passing_email_and_password_with_excel_row(String rows) {
		try {
			datamap = DataReader.data(System.getProperty("user.dir")+"\\testdata\\OpenCart_TestData.xlsx", "Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int index = Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("Username");
		String password=datamap.get(index).get("Password");
		String expectedResult = datamap.get(index).get("Result");
		
		lp=new LoginPage(BaseClass.getDriver());
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		ap=new AccountPage(BaseClass.getDriver());
		try
		{
			boolean pageStatus = ap.isMyAccountPageExists();
			System.out.println(pageStatus);
			if(expectedResult.equalsIgnoreCase("Valid")) {
				if(pageStatus==true) {
					AccountPage ap = new AccountPage(BaseClass.getDriver());
					ap.clickLogout();
					Assert.assertEquals(true, pageStatus);
				}else {
					Assert.assertEquals(true, false);
				}
			}
			if(expectedResult.equalsIgnoreCase("Invalid")) {
				if(pageStatus==true) {
					ap.clickLogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
