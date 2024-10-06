package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']//h2[1]")
	WebElement txt_myaccount;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement txt_registrationSuccess;

	public void clickLogout() {
		btn_logout.click();
	}

	public boolean isMyAccountPageExists() {
		boolean status = false;
		if (txt_myaccount.getText().equals("My Account")) {
			status = true;
		}
		return status;
	}

	public String isAccountCreated() {
		return txt_registrationSuccess.getText();
	}
}
