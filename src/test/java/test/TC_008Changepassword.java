package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.ChangePasswordPage;
import pages.Home;
import pages.WelcomeAdactin;

public class TC_008Changepassword  extends ProjectSpecification {
	@BeforeTest
	public void setup() {
		sheetname="Changepassword";
		testName="change password Test";
		testDescription="Testing the Change password function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void change_PasswordTest(String current_pwd,String new_passwd,String confirmpass,String TestType,String expected)
	{
		Home homeObj=new Home(driver);
		homeObj.EnterUName("Vaishu04")
		.EnterUPassword("Vaishu07")
		.ClickLoginButton();
		WelcomeAdactin WA=new WelcomeAdactin(driver);
		WA.Click_changePassword();
		ChangePasswordPage CPP=new ChangePasswordPage(driver);
	    CPP.Enter_currentpassword(current_pwd)
	    .Enter_Newpassword(new_passwd)
	    .Enter_Repassword(confirmpass)
	    .Click_submit1()
	    .validate_chanepassword(TestType, expected);
		
	}
}