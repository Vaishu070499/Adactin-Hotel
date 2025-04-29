package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class Home extends ProjectSpecification {
	
	@FindBy(linkText="New User Register Here")
    WebElement newRegister;	
	
	@FindBy(linkText="info@adactin.com")
    WebElement ForQuery;	
	
	@FindBy(id="username")
	WebElement  Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(linkText="Forgot Password?")
	WebElement  forgotPassword;
	
	@FindBy(id="login")
	WebElement  LoginButton;
	
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public Registration ClickNewRegister() {
		 newRegister.click();
		 return new Registration(driver);
	 }
	public Home EnterUName(String name)	{
			Username.sendKeys(name);
			return this;
	}
	public Home EnterUPassword(String PassWord) {
		Password.sendKeys(PassWord);
		return this;
	}
	public ValidateLogin ClickLoginButton()	{
		LoginButton.click();
		return new ValidateLogin(driver);
	}
	public ForgotPassword ClickForgotPassword() {
		forgotPassword.click();
		return new ForgotPassword(driver);
	}
		

}