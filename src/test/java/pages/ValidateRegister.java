package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.ProjectSpecification;
import utils.Handling;

public class ValidateRegister extends ProjectSpecification {
	
	@FindBy(id="username_span")
	WebElement usernameError;
	
	@FindBy(id="password_span")
	WebElement PasswordError;
	
	@FindBy(id="re_password_span")
	WebElement ConfirmPasswordError;
	
	@FindBy(id="full_name_span")
	WebElement FullnameError;
	
	@FindBy(id="email_add_span")
	WebElement MailIdError;
	
	@FindBy(id="tnc_span")
	WebElement CheckboxError;
	
	@FindBy(className="login_title_comm")
	WebElement allFieldEmptyError;
	
	@FindBy(linkText="Click here to login")
	WebElement Clicktologin;
	
	public ValidateRegister(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ValidateRegister validateRegister(String Testtype,String expected) {
			
		if (Testtype.equalsIgnoreCase("positive")) {
				
			WebElement ele=Handling.fluentWait(driver,Clicktologin);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("existing  mailid")) {

			WebElement ele=Handling.fluentWait(driver,MailIdError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected); 		
		}
		else if(Testtype.equalsIgnoreCase("Less Than 8 character")) {
			
			WebElement ele=Handling.fluentWait(driver,usernameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Username field empty")) 	{
				
			WebElement ele=Handling.fluentWait(driver,usernameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);		
		}
		else if(Testtype.equalsIgnoreCase("Less Than 6 character")) {
			
			WebElement ele=Handling.fluentWait(driver,PasswordError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);	
		} 
		else if(Testtype.equalsIgnoreCase("mismatch Password")) {
			
			WebElement ele=Handling.fluentWait(driver,ConfirmPasswordError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("password field is Empty")) {
			
			WebElement ele=Handling.fluentWait(driver,PasswordError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("Confirm pwd field empty")) {
			
			WebElement ele=Handling.fluentWait(driver,ConfirmPasswordError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("Full name field is empty")) {
			
			WebElement ele=Handling.fluentWait(driver,FullnameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("Email field is Empty")) {
		
			WebElement ele=Handling.fluentWait(driver,MailIdError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("invalid email format")) {
			
			WebElement ele=Handling.fluentWait(driver,MailIdError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("Existing Username")) {
			
			WebElement ele=Handling.fluentWait(driver,usernameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("All Field Empty")) {
		
			WebElement ele=Handling.fluentWait(driver,allFieldEmptyError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		} 
		else if(Testtype.equalsIgnoreCase("Not Alpha Numeric")) {
			
			WebElement ele=Handling.fluentWait(driver,usernameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);	
		} 
				
		return this;
	}
}