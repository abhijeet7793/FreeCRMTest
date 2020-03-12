package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;  //created at class level so that it can be used throughout the program
	HomePage homePage; // Homeapge reference variable
	
	public LoginPageTest(){
		super();  
		//It is important(compulsary) to create Testbase Class Constructor to initialize properties also. We are using prop variable in initialization method
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();  //coming from TestBase
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();   //object.method   --all non-static methods can be accessed
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	
	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//this method is returning HomePage class object and hence we are storing it in homePage reference variable
		//loginPage.login(prop.getProperty("username"), prop.getProperty("password")) = new HomePage()
		//same as follows
		//HomePage homePage = new Homepage();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
