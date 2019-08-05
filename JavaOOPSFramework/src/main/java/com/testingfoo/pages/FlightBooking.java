package com.testingfoo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightBooking extends BasePage {

	private By oneWayRadioButton=By.xpath("//span[@class='qfa1-radiobutton__label-text'][contains(text(),'One way')]");
	
	private By toField=By.id("typeahead-input-to");
	
	private By departDate=By.id("datepicker-input-departureDate");
	
	private By allValidDates=By.xpath("//td[@class='date-picker__calendar-weekdays-items date-picker__calendar-weekdays-items--enabled']");
	
	private By searchBtn=By.xpath("//button[@class='qfa1-submit-button__button'][contains(text(),'SEARCH FLIGHTS')]");
	
	public FlightBooking(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @return the oneWayRadioButton
	 */
	public WebElement getOneWayRadioButton() {
		return getElement(oneWayRadioButton);
	}

	/**
	 * @return the toField
	 */
	public WebElement getToField() {
		return getElement(toField);
	}


	/**
	 * @return the departDate
	 */
	public WebElement getDepartDate() {
		return getElement(departDate);
	}


	/**
	 * @return the allValidDates
	 */
	public WebElement getAllValidDates() {
		return getElements(allValidDates);
	}


	/**
	 * @return the searchBtn
	 */
	public WebElement getSearchBtn() {
		return getElement(searchBtn);
	}


	public void enterDestination(String location) {
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(toField));
		getToField().sendKeys(location);
		
		//Selecting the element from the autocomplete list
		WebElement element=driver.findElement(By.id("typeahead-list-item-to-list"));
		List<WebElement> listOfEntries=element.findElements(By.tagName("li"));
		
		for(WebElement i:listOfEntries) {

			if(i.getText().contains(location)) {
				i.click();
			} 
		}
	
		wait.until(ExpectedConditions.attributeContains(toField, "aria-expanded", "false"));
		
	}
	
	

}
