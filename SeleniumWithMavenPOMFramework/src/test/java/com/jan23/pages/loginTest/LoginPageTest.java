package com.jan23.pages.loginTest;

import java.lang.reflect.Method;

import org.apache.logging.log4j.core.config.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jan23.pages.home.HomePage;
import com.jan23.pages.login.LoginPage;
import com.jan23.utility.ExtentReportsUtility;
import com.jan23.utility.PropertiesUtility;
import com.jan23base.LoginPageBaseTest;

public class LoginPageTest extends LoginPageBaseTest {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("ApplicationDataProperties");
		String url = propertiesUtility.getPropertyValue("url");
		GetDriverInstance("chrome");
		GoToUrl(url);
		
	}
	
	@Test (enabled = true)
	public void loginTC02() throws InterruptedException {
		
		System.out.println("Inside login method");
		String expected = "Salesforce Homepage";
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardownAfterTestMethod() {
		driver.close();	
	}
	
}
