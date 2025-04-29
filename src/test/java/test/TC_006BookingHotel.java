package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.BookHotel;
import pages.Home;
import pages.SearchHotelPage;
import pages.SelectHotel;

public class TC_006BookingHotel  extends ProjectSpecification {
	
	@BeforeTest
	public void setup() {
		sheetname="BookHotel";
		testName="booking hotel Test";
		testDescription="Testing the Booking Hotel function function";
		testAuthor="Vaishnavi";
		testCategory="Smoke Testing"; 
	}
	
	@Test(dataProvider="readdata")
	public void booking(String fname,String lname,String addr,String CCN,String CCtype,String mon,String years,String cardcvv,String testType,String Expected)
	{
		Home obj=new Home(driver);
		obj.EnterUName("Vaishu99");
		obj.EnterUPassword("Vaishu07");
		obj.ClickLoginButton();
		SearchHotelPage SHP=new SearchHotelPage(driver);
		SHP.ClickSearchHotelReset()
		.select_locator("Melbourne")
		.select_hotel("Hotel Hervey")
		.select_roomtype("Deluxe")
		.select_NumberOfRooms("5")
		.Enter_checkIN("28/05/2025")
		.Enter_checkOUT("03/06/2025")
		.select_AdultperRoom("2")
		.select_ChildrenperRoom("3")
		.Click_Search();
		SelectHotel sh=new SelectHotel(driver);
		sh.Click_SelectHotel()
		.Click_Continue()
		.Enter_Values(fname, lname, addr, CCN, CCtype, mon, years, cardcvv);
		BookHotel bh=new BookHotel(driver);
	     bh.validate_bookhotel(testType, Expected);
	     
	}
		
}