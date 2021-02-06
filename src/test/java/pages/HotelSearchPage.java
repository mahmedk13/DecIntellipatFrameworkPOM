package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelSearchPage extends TestBase {
	
	@FindBy(css="a[href*=wizard-hotel-pwa]")
	private WebElement hotelTab;
	
	@FindBy(css="button[data-stid=location-field-destination-menu-trigger]")
	private WebElement destinationField;
	
	@FindBy(id="location-field-destination")
	private WebElement destinationTxtbx;
	
	@FindBy(id="d1-btn")
	private WebElement checkinCalendar;
	
	@FindBy(css="button[data-stid=apply-date-picker]")
	private WebElement applyBtn;
	
	@FindBy(id="d2-btn")
	private WebElement checkoutCalendar;
	
	@FindBy(css="button[data-testid=submit-button]")
	private WebElement submitBtn;
	
	
	public HotelSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HotelSearchResultsPage searchHotel() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		hotelTab.click();
		
		destinationField.click();		
		destinationTxtbx.sendKeys("Hyderabad", Keys.ENTER);
		
		checkinCalendar.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Mar 17, 2021.']")));
		driver.findElement(By.xpath("//button[@aria-label='Mar 17, 2021.']")).click();
		applyBtn.click();
		
		
		checkoutCalendar.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Mar 20, 2021.']")));
		driver.findElement(By.xpath("//button[@aria-label='Mar 20, 2021.']")).click();
		applyBtn.click();
		
		submitBtn.click();
		
		return new HotelSearchResultsPage();
	}
	
	
	
	
	

}
