package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']//h2[1]")
	WebElement msg_myaccount;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;
	
	@FindBy(xpath = " //div[@id='content']//h1")
	WebElement msg_registrationSuccess;
	
	public void clickLogout() {
		btn_logout.click();
	}
	
	public boolean isMyAccountPageExists() {
		return msg_myaccount.isDisplayed();
	}
	
	public String isAccountCreated() {
		return msg_registrationSuccess.getText();
	}
}
