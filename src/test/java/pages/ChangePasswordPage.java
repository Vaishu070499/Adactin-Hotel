package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;
import utils.Handling;

public class ChangePasswordPage extends ProjectSpecification{
	
	@FindBy(id="current_pass")
	WebElement currentpassword;
	
	@FindBy(id="new_password")
	WebElement newpassword;
	
	@FindBy(id="re_password")
	WebElement Repassword;
	
	@FindBy(id="Submit")
	WebElement SubmitButton1;
	
	@FindBy(xpath="//span[text()='Your Password is successfully updated!!!']")
	WebElement SuccessMessage;
	
	@FindBy(xpath="//span[text()='Please enter correct current password!!!']")
	WebElement ErrorMessage;

	public ChangePasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ChangePasswordPage Enter_currentpassword(String CurrentPass) {
		currentpassword.sendKeys(CurrentPass);
		return this;
		
	}
	public ChangePasswordPage Enter_Newpassword(String newPass) {
		newpassword.sendKeys(newPass);
		return this;	
	}
	
	public ChangePasswordPage Enter_Repassword(String RePass) {
		Repassword.sendKeys(RePass);
		return this;
		
	}
	
	public ChangePasswordPage Click_submit1() {
		SubmitButton1.click();
		return this;
		
	}
	
	public ChangePasswordPage validate_chanepassword(String Testtype,String expected) {
		if (Testtype.equalsIgnoreCase("All text field empty")) {
			
			WebElement ele=Handling.explicitWait(driver,ErrorMessage);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("valid data")) {

			WebElement ele=Handling.explicitWait(driver,SuccessMessage);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
	
		return this;
	}

}