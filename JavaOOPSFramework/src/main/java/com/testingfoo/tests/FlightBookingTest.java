/**
 * 
 */
package com.testingfoo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingfoo.pages.FlightBooking;
import com.testingfoo.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * @author udayseshadri
 *
 */
public class FlightBookingTest extends BaseTest{
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Flight Booking Test")
	@Story("Story Name: To check login page title")
	public void test() {

		HomePage homePage=page.getInstance(HomePage.class);
		String pageTitle=homePage.getPageTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Fly with Australia’s most popular airline | Qantas AU");
		
		FlightBooking flightBooking=homePage.clickFlightLink();
		flightBooking.enterDestination("BNE");
		
		
	}

}
