package com.newtours.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;	

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;
import com.test.baseTest.BaseTest;

public class BookFlightTest extends BaseTest{
		
	 private String noOfPassengers;
	 private String expectedPrice;
	    
//	 
//	@BeforeTest
//	@Parameters({"noOfPassengers","expectedPrice"})
//	public void setUpDriver(String noOfPassengers,String expectedPrice)
//	{	
//		this.expectedPrice=expectedPrice;
//		this.noOfPassengers=noOfPassengers;		
//	}
//	
    @Test
    public void registrationPageTest() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.loadUrl();
        registrationPage.enterUserDetails("Sanjay", "Selenium");
        registrationPage.enterUserCredentials("Sanjay", "Selenium");
        registrationPage.submit();
    }
	
    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPageTest(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }
	
    @Test(dependsOnMethods = "registrationConfirmationPageTest")
    public void flightDetailsPageTest(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers("4");
        flightDetailsPage.goToFindFlightsPage();
    }

//    @Test(dependsOnMethods = "flightDetailsPageTest")
//    public void findFlightPageTest(){
//        FindFlightPage findFlightPage = new FindFlightPage(driver);
//        findFlightPage.submitFindFlightPage();
//        findFlightPage.goToFlightConfirmationPage();
//    }
//
//    @Test(dependsOnMethods = "findFlightPageTest")
//    public void flightConfirmationPageTest(){
//        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
//        String actualPrice = flightConfirmationPage.getPrice();
//        System.out.println(actualPrice);
//        Assert.assertEquals(actualPrice, expectedPrice);
//    }
	

}
