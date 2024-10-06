package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confirmpassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chk_policy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;
	
	public void enterFirstname(String firstname) {
		txt_firstname.clear();
		txt_firstname.sendKeys(firstname);
	}
	
	public void enterLastname(String lastName) {
		txt_lastname.clear();
		txt_lastname.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		txt_email.clear();
		txt_email.sendKeys(email);
	}
	
	public void enterTelephoneNo(String telephone) {
		txt_telephone.clear();
		txt_telephone.sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		txt_confirmpassword.clear();
		txt_confirmpassword.sendKeys(confirmPassword);
	}
	
	public void tickPolicy() {
		chk_policy.click();
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
}
