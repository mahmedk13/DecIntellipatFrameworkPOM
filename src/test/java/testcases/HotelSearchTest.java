package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HotelSearchPage;
import pages.HotelSearchResultsPage;

public class HotelSearchTest {
	
	@BeforeTest
	public void init() {
		TestBase.setUp();
		TestBase.launchBrowser();
	}
	
	
	@Test
	public void searchHotel() {
		
		HotelSearchPage hs = new HotelSearchPage();
		HotelSearchResultsPage hsrp = hs.searchHotel();
		String title = hsrp.fetchTitle();	
		Assert.assertTrue(title.contains("Hyderabad"));
	}
	
	@AfterTest
	public void tearDown() {
		TestBase.closeBrowser();
	}
	
	

}
