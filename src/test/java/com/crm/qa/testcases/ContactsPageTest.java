/*
 * @author Abhijeet D
 * 
 */

package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super(); //initialize properties
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		//testUtil.switchToFrame();  //as contacts link is available inside the frame
		contactsPage = homePage.clickOnContactsLink();   //contactsPage is a reference
	}
	
	/*
	@Test(enabled =false)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	@Test(priority=1)
	public void clickContactsPageLabel(){
		contactsPage.clickContactslink();
	}
	
	*/
	@Test(priority=1)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("Mukta Sharma");
	}
	
	@Test(priority=2)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("Tom Peter");
		contactsPage.selectContactsByName("Tom1 Peter1");

	}
	/*
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname, String email) throws InterruptedException{
		contactsPage.clickOnNewContactLink();
		//contactsPage.createNewContact("Tom1", "Peter1", "Google1@gmail.com");
		contactsPage.createNewContact(firstname, lastname, email);
		
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	*/
	
}
