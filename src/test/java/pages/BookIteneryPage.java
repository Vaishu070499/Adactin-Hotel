package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class BookIteneryPage extends ProjectSpecification {
	
	@FindBy(xpath="//input[@value='Cancel Selected']")
	WebElement cancel;
	
	@FindBy(id="search_hotel")
	WebElement searchHotel;
	
	@FindBy(id="logout")
	WebElement Logout ;
	
	@FindBy(id="order_id_text")
	WebElement  Orderidtext;
	
	@FindBy(id="search_hotel_id")
	WebElement gobutton;
	
	@FindBy(xpath="//tbody/tr[2]/td[3]")
	WebElement deleteFirst ;
	
	@FindBy(xpath="//tbody/tr[3]/td[2]")
	WebElement ordrid;
	
	@FindBy(id="check_all")
	WebElement clickallCheckbox;
	
	public BookIteneryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//in the table
	public BookIteneryPage click_cancelorder() {
		deleteFirst.click();
        driver.switchTo().alert().accept();
		return this;
	}
	
	public SearchHotelPage Click_searchhotel() {
		searchHotel.click();
		return new SearchHotelPage(driver);
	}
	
	//select order id
	public BookIteneryPage enter_orderid() {
		String text=ordrid.getText();
		Orderidtext.sendKeys(text);
		gobutton.click();
		return this;
	}
	
	public BookIteneryPage clickall() {
		clickallCheckbox.click();
		return this;
	}
	
	public BookIteneryPage cancelselected() {
		cancel.click();
		driver.switchTo().alert().accept();
		return this;
	}
	
	public Home2 click_logout() {
		Logout.click();
		return new Home2(driver);
	}
	   
}