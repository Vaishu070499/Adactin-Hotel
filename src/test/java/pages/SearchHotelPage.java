package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import base.ProjectSpecification;

public class SearchHotelPage extends ProjectSpecification{
	@FindBy(id="location")
	WebElement Locate;
	
	@FindBy(id="hotels")
	WebElement Hotels;
	
	@FindBy(id="room_type")
	WebElement roomtype;
	
	@FindBy(id="room_nos")
	WebElement numberofRoom;
	
	@FindBy(id="datepick_in")
	WebElement checkInDate;
	
	@FindBy(id="datepick_out")
	WebElement checkOutDate;
	
	@FindBy(id="adult_room")
	WebElement AdultsPerRoom;
	
	@FindBy(id="child_room")
	WebElement ChildrensPerRoom;
	
	@FindBy(id="Reset")
	WebElement resetbutton;
	
	@FindBy(id="Submit")
	WebElement SearchButton;
	
	
	public SearchHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public SearchHotelPage select_locator(String country) {
		Select Locator = new Select(Locate);
	    Locator.selectByValue(country);
	    return this;
	} 
	
	public SearchHotelPage select_hotel(String HOTEL) {
		Select Hotel = new Select(Hotels);
	    Hotel.selectByValue(HOTEL);
	    return this;
	}
	
	public SearchHotelPage select_roomtype(String ROOM) {
		Select RoomType = new Select(roomtype);
		RoomType.selectByValue(ROOM);
	    return this;
    }
	
	public SearchHotelPage select_NumberOfRooms(String ROOMCount) {
		Select Number_Room = new Select(numberofRoom);
		Number_Room.selectByValue(ROOMCount);
	    return this;
    }
	
	public SearchHotelPage Enter_checkIN(String checkin) {
		checkInDate.clear();
		checkInDate.sendKeys(checkin);
		return this;
    }
	
	public SearchHotelPage Enter_checkOUT(String checkout) {
		checkOutDate.clear();
		checkOutDate.sendKeys(checkout);
		return this;
    }
	
	public SearchHotelPage select_AdultperRoom(String adult) {
		Select count_adult = new Select(AdultsPerRoom);
		count_adult.selectByValue(adult);
	    return this;
    }
	
	public SearchHotelPage select_ChildrenperRoom(String child) {
		Select count_children = new Select(ChildrensPerRoom);
		count_children.selectByValue(child);
	    return this;
    } 
	
	public SelectHotel  Click_Search() {
		SearchButton.click();
		return new SelectHotel(driver);
	}
	
	public SearchHotelPage ClickSearchHotelReset() {
		resetbutton.click();
		return this;
	} 

}