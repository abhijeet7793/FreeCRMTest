package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")  //@FindBy is equivalent to driver.findelement
	WebElement username;  // this is variable
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects/elements:
	public LoginPage(){				//constructor of class
		PageFactory.initElements(driver, this);  //this means its point to the current class objects
		//here driver is coming from TestBase. All the above variables will be initialized with driver
	}
	
	//Actions:
	public String validateLoginPageTitle(){  //this method is returning Title(String) hence return type is String
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){  //returning true/false hence retun type is boolean
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){  //this method is returning Home Page hence return type is HomePage
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		    	//JavascriptExecutor js = (JavascriptExecutor)driver;
		    	//js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();  //HomePage is the landing page of LoginPage
		//After clicking Login, it is moving to Home Page.
		//It will move to Homepage and return Home Page class object
	}
	
}
