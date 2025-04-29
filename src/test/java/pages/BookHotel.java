package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecification;
import utils.Handling;

public class BookHotel extends ProjectSpecification {
	
	
	@FindBy(id="first_name")
	WebElement Firstname;
	
	@FindBy(id="last_name")
	WebElement Lastname;
	
	@FindBy(id="address")
	WebElement Address;
	
	@FindBy(id="cc_num")
	WebElement CreditCard;
	
	@FindBy(id="cc_type")
	WebElement CreditCardType;
	
	@FindBy(id="cc_exp_month")
	WebElement ExpMonth;
	
	@FindBy(id="cc_exp_year")
	WebElement ExpYear;
	
	@FindBy(id="cc_cvv")
	WebElement CVV;
	
	@FindBy(id="book_now")
	WebElement Book;
	
	@FindBy(id="cancel")
	WebElement Cancel;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	WebElement bookingconfirm;

	@FindBy(id="first_name_span")
	WebElement  firstnameError;
	
	@FindBy(id="last_name_span")
	WebElement lastnameError;
	
	@FindBy(id="address_span")
	WebElement addressError;
	
	@FindBy(id="cc_num_span")
	WebElement creditcardnumError;
	
	@FindBy(id="cc_type_span")
	WebElement creditTypeError ;
	
	@FindBy(id="cc_expiry_span")
	WebElement expiryError;
	
	@FindBy(id="cc_cvv_span")
	WebElement cvvError;
	
	
	public BookHotel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public BookingConfirmation Enter_Values(String fname,String lname,String address,String CCNum,String CCTPE,String expmonth,String expyear,String Cvv)
	{
		Firstname.sendKeys(fname);
		Lastname.sendKeys(lname);
		Address.sendKeys(address);
		CreditCard.sendKeys(CCNum);
		
		Select Type=new Select(CreditCardType);
		Type.selectByVisibleText(CCTPE);
		
		Select exp_Month=new Select(ExpMonth);
		exp_Month.selectByVisibleText(expmonth);
		
		Select Year=new Select(ExpYear);
		Year.selectByVisibleText(expyear);
		CVV.sendKeys(Cvv);
		Book.click();
		return new BookingConfirmation(driver);
		
	}
	
	public BookHotel  validate_bookhotel(String testtype,String expected) {
	
		if(testtype.equalsIgnoreCase("All field Empty")) {
			WebElement ele=Handling.explicitWait(driver, firstnameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(testtype.equalsIgnoreCase("Firstname field empty")) {
			WebElement ele=Handling.explicitWait(driver, firstnameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(testtype.equalsIgnoreCase("Lastname field empty")) {
	
			WebElement ele=Handling.explicitWait(driver, lastnameError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(testtype.equalsIgnoreCase("address field empty")) {
			WebElement ele=Handling.explicitWait(driver, addressError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(testtype.equalsIgnoreCase("creditcard field empty")){
	
			WebElement ele=Handling.explicitWait(driver, creditcardnumError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(testtype.equalsIgnoreCase("enter less than 16 digit")) {
			WebElement ele=Handling.explicitWait(driver, creditcardnumError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(testtype.equalsIgnoreCase("creditcard  type field empty")) {
			WebElement ele=Handling.explicitWait(driver, creditTypeError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
	    }	
		else if(testtype.equalsIgnoreCase("expiry month field empty")) {
			WebElement ele=Handling.explicitWait(driver, expiryError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
	    }
			
		else if(testtype.equalsIgnoreCase("expiry year field empty")) {
			WebElement ele=Handling.explicitWait(driver, expiryError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
	    }	
		else if(testtype.equalsIgnoreCase("cvv field empty")) {
			WebElement ele=Handling.explicitWait(driver, cvvError);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
		}
			
		else if(testtype.equalsIgnoreCase("valid data")) {
			WebElement ele=Handling.explicitWait(driver,bookingconfirm);
			String actualText=ele.getText();
			Assert.assertEquals(actualText, expected);
	    }
			
		return this;
	}

}