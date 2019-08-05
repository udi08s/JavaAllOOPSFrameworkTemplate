package com.testingfoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			waitForElementPresent(locator);
			element=driver.findElement(locator);
			return element;
		}
		catch(Exception e) {
			System.out.println("Exception in the getElement method.. of BasePage");
			e.printStackTrace();
		}
		
		return element;
	}
	
	public WebElement getElements(By locator) {
		WebElement elements=null;
		try {
			waitForElementsPresent(locator);
			elements=driver.findElement(locator);
			return elements;
		}
		catch(Exception e) {
			System.out.println("Exception in the getElement method.. of BasePage");
			e.printStackTrace();
		}
		
		return elements;
	}
	
	public void waitForElementsPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
		}
		catch(Exception e) {
			System.out.println("Exception occured in BasePage while waiting for element"+locator.toString());
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		}
		catch(Exception e) {
			System.out.println("Exception occured in BasePage while waiting for element"+locator.toString());
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void waitForPageTitle(String title) {
		
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e) {
			System.out.println("Exception occured in BasePage while waiting for title"+title);
			e.printStackTrace();
		}
		
	}
	
	

}
