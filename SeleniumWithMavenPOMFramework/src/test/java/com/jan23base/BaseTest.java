package com.jan23base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//import java.util.logging.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.jan23.utility.Constants;
import com.jan23.utility.ExtentReportsUtility;
import com.jan23.utility.PropertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected static Logger logger = null;
	protected static ExtentReportsUtility extentreport = ExtentReportsUtility.getInstance() ;
	
	//@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("chrome")String browserName, Method method, ExtentReportsUtility extentreport) {
		logger.info("started testscript name" + method.getName());
		extentreport.logTestInfo("started testscript name" +  method.getName());
		
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("ApplicationDataProperties");
		String url = PropertiesUtility.getPropertyValue("url");
		GetDriverInstance(browserName);
		goToUrl(url);
	}
	
	@AfterMethod
	public void teardownAfterTestMethod() {
		driver.close();	
	}
	
	public static void enterText(WebElement element, String text, String name) {
		if (element.isDisplayed()) {
			clearElement(element, name);
			element.sendKeys(text);
			//System.out.println("text entered in"+ name +"field");
			logger.info("text entered in" + name + "field");
			extentreport.logTestInfo("text entered in" + name + "field");
			}
		else {
			logger.info("fail: " + name + "element not displayed");
			extentreport.logTestInfo("fail: " + name + "element not displayed");
			//System.out.println("fail:" + name + "element not displayed");
	}
		driver.getTitle();
	}	
	
	private static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			logger.info("pass" + objName + "element cleared");
			extentreport.logTestInfo("pass" + objName + "element cleared");
		}
		else {
			logger.info("fail" + objName + "element not displayed");
			extentreport.logTestInfo("fail" + objName + "element not displayed");
		}
		
	}
	private static void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			logger.info("pass" + objName + "element clicked");
			extentreport.logTestInfo("pass" + objName + "element clicked");
		}
		else {
			logger.info("fail" + objName + "element not displayed");
			extentreport.logTestInfo("fail" + objName + "element not displayed");
		}
	}
	
	public static  Alert switchToAlert() {
		
		WaitUntilAlertIsPresent();
		Alert alert = driver.switchTo().alert();
		logger.info("Switched to alert");
		extentreport.logTestInfo("Switched to alert");
		return alert;
	}
	
	public static void AcceptAlert(Alert alert) {
		
		logger.info("Alert accepted");
		extentreport.logTestInfo("Alert accepted");
		return;
	}
	
	public static String getAlertText(Alert alert) {
		
		logger.info("extracting text in the alert");
		extentreport.logTestInfo("extracting text in the alert");
		return alert.getText();
	}
	
	public static void dismisAlert() {
		
		WaitUntilAlertIsPresent();
		Alert alert = switchToAlert();
		alert.dismiss();
		logger.info("Alert dismissed");
		extentreport.logTestInfo("Alert dismissed");
	}
	
	public static void selectByTextData(WebElement element, String text, String objName) {
		
		Select selectObject = new Select (element);
		selectObject.selectByVisibleText(text);
		logger.info(objName +"selected" + text);
		extentreport.logTestInfo(objName +"selected" + text);
	}
	
    public static void selectByIndexData(WebElement element, int index, String objName) {
		
		Select selectObject = new Select (element);
		selectObject.selectByIndex(index);
		logger.info(objName +"selected");
		extentreport.logTestInfo(objName +"selected");
    }
    
   public static void selectByValueData(WebElement element, String text, String objName) {
		
		Select selectObject = new Select (element);
		selectObject.selectByValue(text);
		logger.info(objName +"selected");
		extentreport.logTestInfo(objName +"selected");
   }
	
    public static void goToUrl (String url) {
    	logger.info("going to the url=" + url);
    	extentreport.logTestInfo("going to the url=" + url);
    	driver.get(url);
	}
	public static void closeBrowser() {
		logger.info("closing the browser");
		extentreport.logTestInfo("closing the browser");
		driver.close();
	}
	
	public static String getPageTitle() {
		logger.info("getting the page title");
		extentreport.logTestInfo("getting the page title");
		return driver.getTitle();
	}
	
	public static void refreshPage() {
		logger.info("reffrershing page");
		extentreport.logTestInfo("reffrershing page");
		driver.navigate().refresh();
	}
	public static void waitUntilPageLoads() {
		logger.info("wait until page load");
		extentreport.logTestInfo("wait until page load");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	public WebDriver returnDriverInstance() {
		return driver;
	}
	
	public static void WaitUntilElementIsVisible(WebElement ele, String objName ) {
		logger.info("waiting for an webelement"+ objName + "for its visibility");
		extentreport.logTestInfo("waiting for an webelement"+ objName + "for its visibility");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
   public static void WaitUntilAlertIsPresent() {
		logger.info("waiting for alert to be present");
		extentreport.logTestInfo("waiting for alert to be present");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
   public static void WaitUntilElementToBeClickable(By locator, String objName ) {
		logger.info("waiting for an webelement"+ objName + "to be clickable");
		extentreport.logTestInfo("waiting for an webelement"+ objName + "to be clickable");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
   
	
	public static void GetDriverInstance (String browserName) {
		
		switch(browserName) {
		case "edge":    WebDriverManager.firefoxdriver().setup();
		                   driver = new FirefoxDriver();
		                   driver.manage().window().maximize();
		                   break;
		                
		case "chrome":     WebDriverManager.chromedriver().setup();
                           driver = new ChromeDriver();
                           driver.manage().window().maximize();
                           break;  
                           
        default :          logger.info("Proper browsername not entered");                   
                           extentreport.logTestInfo("Proper browsername not entered");         
		}
	}
	
	public static String getTextFromWebElement(WebElement element, String name) {
		if (element.isDisplayed()) {
		return element.getText();
		}
		else {
			logger.info(name + " Webelement is not displayed");
			extentreport.logTestInfo(name + " Webelement is not displayed");
			return null;
		}
	}
		
	public static void GoToUrl(String url) {
		logger.info("go to URL");
		extentreport.logTestInfo("go to URL");
		driver.get(url);
	}
	/*public static void enterText (WebElement element, String text, String name) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println(name + "Webelement is not displayed");
	}
	    driver.getTitle();
	}*/
	
	public static String getScreenShotOfThePage(WebDriver driver) {
		
		//random value + date()+testcase name ---> filename
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String curDir = System.getProperty("user.dir");
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH + date + ".png");
		try {
		FileHandler.copy(imgFile, destFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
       return destFile.getAbsolutePath();
	} 
}
