package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.BaseClass;
import utilities.DataReader;

public class LoginSteps_DDT {

	WebDriver driver;

	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	
	List<HashMap<String, String>> datamap;

	@Then("User should be redirected to the myaccount page by passing email and password with excel row {string}")
	public void user_should_be_redirected_to_the_myaccount_page_by_passing_email_and_password_with_excel_row(
			String rows) {
		try {
				datamap = DataReader.data(System.getProperty("user.dir") + "\\testdata\\Opencart_Testdata.xlsx", "Sheet1");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("Username");
		String password = datamap.get(index).get("Password");
		String expectedResult = datamap.get(index).get("Result");
		
		loginpage = new LoginPage(BaseClass.getDriver());
		BaseClass.getLogger().info("Entered email.");
		loginpage.enterEmail(email);
		BaseClass.getLogger().info("Entered password.");
		loginpage.enterPassword(password);
		BaseClass.getLogger().info("Clicked login.");
		loginpage.clickLogin();

		accountpage = new AccountPage(BaseClass.getDriver());

		try {
			boolean pageStatus = accountpage.isMyAccountPageExists();
			if (expectedResult.equalsIgnoreCase("Valid")) {
				if (pageStatus == true) {
					BaseClass.getLogger().info(expectedResult+" user: "+email);
					BaseClass.getLogger().info("User logged in successfully.");
					BaseClass.scrollToHeight();
					BaseClass.getLogger().info("Clicked logout.");
					accountpage.clickLogout();
					Assert.assertTrue(pageStatus);
				} else {
					BaseClass.getLogger().info(expectedResult+" user: "+email);
					BaseClass.getLogger().info("User login failed.");
					Assert.assertTrue(pageStatus);
				}
			}
			if (expectedResult.equalsIgnoreCase("Invalid")) {
				if (pageStatus == true) {
					BaseClass.getLogger().info(expectedResult+" user: "+email);
					BaseClass.getLogger().info("User logged in.");
					BaseClass.scrollToHeight();
					BaseClass.logger.info("Clicked logout.");
					accountpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					BaseClass.getLogger().info(expectedResult+" user: "+email);
					BaseClass.getLogger().info("User login failed.");
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
