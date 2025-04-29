package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Home;

public class TC_003Login extends ProjectSpecification {
	
	@BeforeTest
	public void setup() {
		sheetname="login";
		testName="login Test";
		testDescription="Testing the login function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void userRegistration(String name,String passwd,String TestType,String expected) {
		Home homeObj=new Home(driver);
		homeObj.EnterUName(name)
		.EnterUPassword(passwd)
		.ClickLoginButton()
		.validate_login(TestType, expected);
			
	}

}