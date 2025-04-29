package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Home;

public class TC_002ResetData extends ProjectSpecification{
	
	@BeforeTest
	public void setup() {
		sheetname="Reset";
		testName="RESETdata Test";
		testDescription="Testing the Rgistration reset data function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void userRegistration(String name,String passwd,String Cpasswd,String Fname,String eid) {
		Home homeObj=new Home(driver);
		homeObj.ClickNewRegister()
		.Enter_Name(name)
		.Enter_Password(passwd)
		.Enter_ConfirmPassword(Cpasswd)
		.Enter_FullName(Fname)
		.Enter_Email(eid)
		.ClickReset();
		
	}

}