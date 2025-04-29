package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Home;
import pages.WelcomeAdactin;

public class TC_009Logout extends ProjectSpecification {
	
	@BeforeTest
	public void set() {
		testName="logout Test";
		testDescription="Testing the logout function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test
	public void LOGOUT_test()
	{
		Home homeObj=new Home(driver);
		homeObj.EnterUName("Vaishu99")
		.EnterUPassword("Vaishu07")
		.ClickLoginButton();
		WelcomeAdactin WA=new WelcomeAdactin(driver);
		WA.Click_LogoutButton();
	}

}