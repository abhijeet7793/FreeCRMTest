package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	@CacheLookup  // it will store the userNamelabel in cache. Whenever you are interacting with element, instead of page it will get the element from cache
	//speed performance for the framework is improved
	//it will create one small memory & it will store that element in memory, cache i.e. called cache memory
	WebElement userNameLabel;  //it looks for the element in the DOM

	@FindBy(xpath = "//div[@id='main-nav']//a[3]")
	WebElement contactsLink;


	@FindBy(xpath = "//div[@id='main-nav']//a[5]")
	WebElement dealsLink;

	@FindBy(xpath = "//body//a[6]")
	WebElement tasksLink;
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement crmLogo;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public String verifyCorrectUserName(){
		return userNameLabel.getText();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
		//whenever after clicking on any link is navigating to next page, then the method should return that page object
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	

	

}
