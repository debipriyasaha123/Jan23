package com.jan23base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.jan23.utility.ExtentReportsUtility;
import com.jan23.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageBaseTest {
	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected static Logger logger = null;
	protected static ExtentReportsUtility extentreport = ExtentReportsUtility.getInstance() ;
	
	@BeforeTest
	public void setUpBeforeTest() {
		
		logger = LogManager.getLogger(LoginPageBaseTest.class.getName());
		extentreport = new ExtentReportsUtility();
		extentreport.startExtentReport();
			
	}
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("chrome")String browserName, Method method) {	
		extentreport.startSingleTestReport("testcase");	
		logger.info("started testscript name"+ method.getName());
		extentreport.logTestInfo("started testscript name"+ method.getName());
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("ApplicationDataProperties");
		String url = PropertiesUtility.getPropertyValue("url");
		//String UserName = PropertiesUtility.getPropertyValue("login.valid.username");
		//String PassWord = PropertiesUtility.getPropertyValue("login.valid.password");
		GetDriverInstance(browserName);
		GoToUrl(url);
	}
	
	@AfterTest
	public void teardownAfterTest() {
		
		extentreport.endReport();
	}
	
	public static void GetDriverInstance (String browserName) {
			
			switch(browserName) {
			case "edge":       WebDriverManager.edgedriver().setup();
			                   driver = new EdgeDriver();
			                   driver.manage().window().maximize();
			                   break;
			                
			case "chrome":     WebDriverManager.chromedriver().setup();
	                           driver = new ChromeDriver();
	                           driver.manage().window().maximize();
	                           break;  
	                           
	        default :          System.out.println("Proper browsername not entered");                   
			}
		}	
		
	public static void GoToUrl(String url) {
		
		driver.get(url);
		
	}
	public static void enterText (WebElement element, String text, String name) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println(name + "Webelement is not displayed");
	}
	    driver.getTitle();
	}
	
}
