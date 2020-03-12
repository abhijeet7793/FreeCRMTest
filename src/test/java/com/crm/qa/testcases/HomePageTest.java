package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage; //this is object reference
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod  ////before each test case -- launch the browser and login
	public void setUp() {
		initialization();
		testUtil = new TestUtil(); //create the object to call swtchtoFrame method available in TestUtil class
		contactsPage = new ContactsPage();
		loginPage = new LoginPage(); //we need to create loginPage object to call the login methods
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  //prop is also initialized here using inheritance
		//login method is returning HomePage
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();   //object.method
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = homePage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyUserNameTest(){
		String name=homePage.verifyCorrectUserName();
		Assert.assertEquals(name, "John Smit1h");
		System.out.println(name);
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest(){
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
