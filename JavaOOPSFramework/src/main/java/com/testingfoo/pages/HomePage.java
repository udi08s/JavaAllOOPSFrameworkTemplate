/**
 * 
 */
package com.testingfoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author udayseshadri
 *
 */
public class HomePage extends BasePage {
	
	//Page Locator
	
	private By bookAFlight=By.id("panel-book-a-trip");
	
	private By flightLink=By.id("panel-flights");
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//getters

	/**
	 * @return the bookAFlight
	 */
	public WebElement getBookAFlight() {
		return getElement(bookAFlight);
	}

	/**
	 * @return the flightLink
	 */
	public WebElement getFlightLink() {
		return getElement(flightLink);
	}

	public String getHomePageTitle() {
		return getPageTitle();
	}	
	
	
	/**
	 * @return FlightBooking
	 */
	public FlightBooking clickFlightLink() {
		getFlightLink().click();
		
		return getInstance(FlightBooking.class);
		
	}

}
