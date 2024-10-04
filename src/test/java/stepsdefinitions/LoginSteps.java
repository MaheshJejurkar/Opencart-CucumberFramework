package stepsdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
	WebDriver driver;
	
	@Given("the user is on the ecommerce login page")
	public void the_user_is_on_the_ecommerce_login_page() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	}

	@When("the user enters valid credentials \\(username:{string}, password:{string})")
	public void the_user_enters_valid_credentials_username_password(String username, String password) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	}


	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	@Then("the user should be redirected to the my account page")
	public void the_user_should_be_redirected_to_the_my_account_page() throws Exception {
		Thread.sleep(1000);
		boolean status = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).isDisplayed();
		Assert.assertEquals(true, status);
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() throws Exception {
		Thread.sleep(1000);
		String actual_text = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).getText();
		String expected_text = "My Account";
		Assert.assertEquals(expected_text, actual_text);
		driver.close();
	}
}
