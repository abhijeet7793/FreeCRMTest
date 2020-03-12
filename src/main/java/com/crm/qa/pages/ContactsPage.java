package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@id='main-nav']//a[3]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void clickContactslink()
	{
		contactsLabel.click();
	}
	
	public void clickOnNewContactLink(){
		newContactLink.click();
		
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div[@class=\"ui fitted read-only checkbox\"]")).click();
		
		//td[text()='"+name+"']//preceding-sibling::td//div[@class="ui fitted read-only checkbox"]
	}
	
	
	public void createNewContact(String ftName, String ltName, String emailid) throws InterruptedException{
	
		firstName.sendKeys(ftName); //firstname
		lastName.sendKeys(ltName); // lastname
		email.sendKeys(emailid); //company
		saveBtn.click();
		Thread.sleep(2000);
		
	}
	
	
	

}
