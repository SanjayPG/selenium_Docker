package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "firstName")
	private WebElement firstNameTxt;

	@FindBy(name = "lastName")
	private WebElement lastNameTxt;

	@FindBy(name = "email")
	private WebElement usernameTxt;

	@FindBy(name = "password")
	private WebElement passwordTxt;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordTxt;

	@FindBy(name = "submit")
	private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

	
	public void loadUrl() {
		driver.get("http://demo.guru99.com/test/newtours/register.php");
	//	wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));		
	}

	  public void enterUserDetails(String firstName, String lastName) throws InterruptedException{
		   // Thread.sleep(5000);
	        this.firstNameTxt.sendKeys(firstName);
	        this.lastNameTxt.sendKeys(lastName);
	    }

	    public void enterUserCredentials(String username, String password){
	        this.usernameTxt.sendKeys(username);
	        this.passwordTxt.sendKeys(password);
	        this.confirmPasswordTxt.sendKeys(password);
	    }

	    public void submit(){
	        this.submitBtn.click();
	    }
}
