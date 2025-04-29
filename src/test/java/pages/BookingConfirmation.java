package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecification;

public class BookingConfirmation extends ProjectSpecification {
	
	@FindBy(id="search_hotel")
	WebElement searchhotel;
	
	@FindBy(id="my_itinerary")
	WebElement itinerary;
	
	@FindBy(id="logout")
	WebElement Logout;
	
	public BookingConfirmation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public BookIteneryPage Click_itinerary() {
		itinerary.click();
		return new BookIteneryPage(driver);
	}
	
	public SearchHotelPage Click_SearchHotel() {
		searchhotel.click();
		return new SearchHotelPage(driver);
	}
	
	public void Click_logout() {
		Logout.click();
	}
}