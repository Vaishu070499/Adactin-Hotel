package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;
import utils.Handling;

public class Home2 extends ProjectSpecification {
		
	@FindBy(linkText="Click here to login")
	WebElement Clickheretologin;
	
	@FindBy(id="emailadd_span")
	WebElement emailaddError;
	
	public Home2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public Home2 validate_Email(String Testtype,String expected) {
		
		if (Testtype.equalsIgnoreCase("invalid email")) {
			
			WebElement ele=Handling.explicitWait(driver,emailaddError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("empty email field")) {

			WebElement ele=Handling.explicitWait(driver,emailaddError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("valid email")) {

			WebElement ele=Handling.explicitWait(driver,Clickheretologin);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		return this;
	}
	
	public Home clickhereLogin() {
		Clickheretologin.click();
		return new Home(driver);
	}

}