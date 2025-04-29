package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Home;

public class TC_001Resgistration extends ProjectSpecification{
	
	@BeforeTest
	public void setup() {
		sheetname="Register";
		testName="Registration Test";
		testDescription="Testing the Rgistration function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void userRegistration(String name,String passwd,String Cpasswd,String Fname,String eid,String TestType,String expected)
	{
		Home homeObj=new Home(driver);
		homeObj.ClickNewRegister()
		.Enter_Name(name)
		.Enter_Password(passwd)
		.Enter_ConfirmPassword(Cpasswd)
		.Enter_FullName(Fname)
		.Enter_Email(eid)
		.ClickCheckbox()
		.Click_Submit()
		.validateRegister(TestType, expected);
		
	}

}