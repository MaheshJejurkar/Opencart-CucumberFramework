package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement btn_myaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement btn_rgister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txt_search;
	
	@FindBy(xpath = "//div[@id='search']//button[@type='button']")
	WebElement btn_search;
	
	public void clickMyaccount() {
		btn_myaccount.click();
	}
	
	public void clickRegister() {
		btn_rgister.click();
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void clickSearch() {
		btn_search.click();
	}
	
	public void enterProductname(String productname) {
		txt_search.clear();
		txt_search.sendKeys(productname);
	}
	
	
	
	

}
