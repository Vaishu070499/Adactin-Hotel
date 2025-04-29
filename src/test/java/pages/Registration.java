package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class Registration extends ProjectSpecification {
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="re_password")
	WebElement ConfirmPassword;
	
	@FindBy(id="full_name")
	WebElement Fullname;
	
	@FindBy(id="email_add")
	WebElement emailid;
	
	@FindBy(id="tnc_box")
	WebElement Checkbox;
	
	@FindBy(linkText="Terms & Conditions")
	WebElement Terms;
	
	@FindBy(id="Submit")
	WebElement submitRegister;
	
	@FindBy(id="Reset")
	WebElement ResetRegister;
	
	@FindBy(linkText="Go back to Login page")
	WebElement gobacktoLogin;
	
	public Registration (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public Registration Enter_Name(String name) {
		Username.sendKeys(name);
		return this;
	}
	
	public Registration Enter_Password(String pwd) {
		Password.sendKeys(pwd);;
		return this;
	}
	
	public Registration Enter_ConfirmPassword(String cpwd) {
		ConfirmPassword.sendKeys(cpwd);
		return this;
	}
	
	public Registration Enter_FullName(String fullname) {
		Fullname.sendKeys(fullname);
		return this;
	}
	
	public Registration Enter_Email(String email) {
		emailid.sendKeys(email);
		return this;
	}
	
	public Registration ClickCheckbox() {
		Checkbox.click();
		return this;
	}
	
	public ValidateRegister Click_Submit() {
		submitRegister.click();
		return new  ValidateRegister(driver);
	}
	
	public Registration ClickReset() {
		ResetRegister.click();
		return this;
		
	}
	
	public Home GoBackLogin() {
		gobacktoLogin.click();
		return new Home(driver);
	}

}