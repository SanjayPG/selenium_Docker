package com.test.baseTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setupDriver() throws MalformedURLException
	{
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\sanjay.pg\\Downloads\\chromedriver\\chromedriver.exe");
//		this.driver=new ChromeDriver();	
//		
		
		 String host = null;
	     DesiredCapabilities dc;

	        if(System.getProperty("BROWSER") != null &&
	                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
	            dc = DesiredCapabilities.firefox();
	            dc.setCapability("marionette", true);
	        }else{
	            dc = DesiredCapabilities.chrome();
	        }

	        if(System.getProperty("HUB_HOST") != null){
	            host = System.getProperty("HUB_HOST");
	        }else {
	        	host="localhost";
	        }

	        String completeUrl = "http://" + host + ":4444/wd/hub";
	    //    dc.setCapability("name", testName);
	        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);	
		
	}
	
	@AfterTest
	public void tearDown()
	{
		this.driver.quit();
	}
	

}
