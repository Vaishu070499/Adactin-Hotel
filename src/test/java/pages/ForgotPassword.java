package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecification;

public class ForgotPassword extends ProjectSpecification{
	
	@FindBy(id="emailadd_recovery")
	WebElement emailadd;
	
	@FindBy(id="Submit")
	WebElement submitEmail;
	
	@FindBy(id="Reset")
	WebElement reset;
	
	@FindBy(linkText="Go back to Login page")
	WebElement gobacklogin;
	
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public ForgotPassword EnterMailId(String maild) {
		emailadd.sendKeys(maild);
		return this;
	}
	public ForgotPassword ClickReset() {
		reset.click();
		return this;
	}
	public Home2 ClickSubmit() {
		submitEmail.click();
		return  new Home2(driver);
	}

}