/**
 * 
 */
package com.testingfoo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.testingfoo.pages.BasePage;
import com.testingfoo.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author udayseshadri
 *
 */
public class BaseTest {
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUpTest(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser to initialise");
		}
		
		driver.get("https://www.qantas.com/au/en.html");
		
		page = new BasePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
