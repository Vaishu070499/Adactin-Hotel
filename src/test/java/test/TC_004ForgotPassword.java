package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Home;

public class TC_004ForgotPassword extends ProjectSpecification {
	
	@BeforeTest
	public void setup() {
		sheetname="forgot password";
		testName="forgot password Test";
		testDescription="Testing the Forgot password function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void ForgotpasswordTest(String mail,String testType,String Expected) {
		
		Home obj=new Home(driver);
		obj.ClickForgotPassword()
		.EnterMailId(mail)
		.ClickReset()
		.EnterMailId(mail)
		.ClickSubmit()
		.validate_Email(testType, Expected);
	}

}