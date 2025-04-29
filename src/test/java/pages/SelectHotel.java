package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;
import utils.Handling;

public class SelectHotel extends ProjectSpecification {
		
	@FindBy(id="location_span")
	WebElement locationError;
	
	@FindBy(id="num_room_span")
	WebElement NumberRoomError;
	
	@FindBy(id="checkin_span")
	WebElement checkInError;
	
	@FindBy(id="checkout_span")
	WebElement checkOutError;
	
	@FindBy(id="adults_room_span")
	WebElement adultsError;
	
	@FindBy(xpath="//span[text()='(Fields marked with Red asterix (*) are mandatory)']")
	WebElement FieldsError;
	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement selecthotel;
	
	@FindBy(xpath="((//table)[5]//tr[2]//td[1]//input)[1]")
	WebElement radiobutton;
	
	@FindBy(id="continue")
	WebElement Continue;
	
	public SelectHotel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public  SelectHotel validate_SearchHotel(String Testtype,String expected) {
		
		if (Testtype.equalsIgnoreCase("All Field Empty")) {
			
			String actualText=FieldsError.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Empty location field")) {

			WebElement ele=Handling.explicitWait(driver,locationError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Empty number of  rooms field")) {

			WebElement ele=Handling.explicitWait(driver,NumberRoomError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Empty checkin field")) {

			WebElement ele=Handling.explicitWait(driver,checkInError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Empty checkout field")) {

			WebElement ele=Handling.explicitWait(driver,checkOutError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Empty adult per room field")) {

			WebElement ele=Handling.explicitWait(driver,adultsError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Enter the checkout date befor checkindate")) {

			WebElement ele=Handling.explicitWait(driver,checkInError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("Enter the checkout date befor checkindate")) {

			WebElement ele=Handling.explicitWait(driver,checkOutError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("valid  data")) {

			WebElement ele=Handling.explicitWait(driver,selecthotel);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("valid  data")) {

			WebElement ele=Handling.explicitWait(driver,selecthotel);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		return this;
		
	}
	
	public SelectHotel Click_SelectHotel() {
		radiobutton.click();
		return this;
	}
	
	public BookHotel Click_Continue() {
		Continue.click();
		return  new BookHotel(driver);
	}
	
}