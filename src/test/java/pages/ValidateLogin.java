package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;
import utils.Handling;

public class ValidateLogin  extends ProjectSpecification{
	
	@FindBy(id="username_span")
	WebElement usernameError;
	
	@FindBy(id="password_span")
	WebElement passwordError;
	
	@FindBy(xpath="//table/tbody/tr/td[text()='Welcome to Adactin Group of Hotels']")
	WebElement successfulLogin;
	
	@FindBy(xpath="//div/b")
	WebElement invalidlogin;
	
	public ValidateLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ValidateLogin validate_login(String Testtype,String expected) {
	
		if (Testtype.equalsIgnoreCase("valid name valid password"))	{
				
			WebElement ele=Handling.explicitWait(driver,successfulLogin);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("empty name field and valid password")) {

			WebElement ele=Handling.explicitWait(driver,usernameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("valid name  empty password field")) {
			WebElement ele=Handling.explicitWait(driver,passwordError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("invalid user name")) {
			WebElement ele=Handling.explicitWait(driver,invalidlogin);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("empty user and empty password field")) {
			WebElement ele=Handling.explicitWait(driver,usernameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("valid name invalid password")) {

			WebElement ele=Handling.explicitWait(driver,invalidlogin);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		return this;
    }
	
}