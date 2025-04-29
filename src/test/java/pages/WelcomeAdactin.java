package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class WelcomeAdactin extends ProjectSpecification{
	
	@FindBy(linkText="Search Hotel")
	WebElement searchHotel;
	
	@FindBy(linkText="Booked Itinerary")
	WebElement bookedItinerary;
	
	@FindBy(linkText="Change Password")
	WebElement changePassword;
	
	@FindBy(linkText="Logout")
	WebElement LogoutButton;
	
	public WelcomeAdactin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public SearchHotelPage Click_searchHotel() {
		searchHotel.click();
		return new SearchHotelPage(driver);
	}
	
	public void Click_bookedItinerary() {
		bookedItinerary.click();
	}
	
	public void Click_changePassword() {
		changePassword.click();
	}
	
	public Home Click_LogoutButton() {
		LogoutButton.click();
		return new Home(driver);
	}

}