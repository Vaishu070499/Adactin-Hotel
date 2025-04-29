package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Home;
import pages.SearchHotelPage;

public class TC_005SearchHotel extends ProjectSpecification {
	
	@BeforeTest
	public void setup() {
		sheetname="Searchhotel";
		testName="search hotel Test";
		testDescription="Testing the  Search Hotel function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void SeachHotelTest(String Locat,String HOtel,String ROomtype,String NOR,String CID,String COD,String APR,String CPR,String testType,String Expected)
	{
		Home obj=new Home(driver);
		obj.EnterUName("Vaishu99");
		obj.EnterUPassword("Vaishu07");
		obj.ClickLoginButton();
		SearchHotelPage SHP=new SearchHotelPage(driver);
		SHP.ClickSearchHotelReset()
		.select_locator(Locat)
		.select_hotel(HOtel)
		.select_roomtype(ROomtype)
		.select_NumberOfRooms(NOR)
		.Enter_checkIN(CID)
		.Enter_checkOUT(COD)
		.select_AdultperRoom(APR)
		.select_ChildrenperRoom(CPR)
		.Click_Search()
		.validate_SearchHotel(testType, Expected);

	}
}