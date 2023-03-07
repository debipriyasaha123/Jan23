package com.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionForSalesforce {

	WebDriver driver;
	
	/*@Given("application is up and running and in loginpage")
	public void application_is_up_and_running_and_in_loginpage() {
	  
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/login/");
		driver.manage().window().maximize();
		
	}
	
	@When("i enter username and password")
	public void i_enter_username_and_password() throws InterruptedException {
	   
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("debipriya_1@tekarch.com");
		//enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("tuktuki123");
		//enterText (password, "tuktuki123", "passwordEle");
		
		
	}
	@When("click on the login button")
	public void click_on_the_login_button() {
	  
		driver.findElement(By.id("Login")).click();
		
	}
	@Then("i should get the home page")
	public void i_should_get_the_home_page() {
	  
		String expected = "Home Page ~ Salesforce - Developer Edition";
		WebElement textElement = driver.findElement(By.xpath("/html/head/title"));
		//String actual = getTextFromWebelement(textElement, "Home Page ~ Salesforce - Developer Edition");
		if (textElement.isDisplayed()) {
			String Actual = textElement.getText();
			if(Actual.equalsIgnoreCase(expected)) {
				System.out.println("Testcase Passed");
			}
			else {
				System.out.println("Testcase Failed");
			}
		}else {
			System.out.println("Element is not displayed for Salesforce Home page");
		}
	
	  }*/
	
	@Given("application is up and running and in loginpage")
	public void application_is_up_and_running_and_in_loginpage() {
	  
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/login/");
		driver.manage().window().maximize();
	}
	@When("i enter username and password")
	public void i_enter_username_and_password() throws InterruptedException {
	  
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("debipriya_1@tekarch.com");
		//enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("tuktuki123");
		//enterText (password, "tuktuki123", "passwordEle");
	}
	@When("click on the login button")
	public void click_on_the_login_button() {
	  
		driver.findElement(By.id("Login")).click();
		
	}
	@Then("i should get the home page")
	public void i_should_get_the_home_page() {
	  
		String expected = "Home Page ~ Salesforce - Developer Edition";
		WebElement textElement = driver.findElement(By.xpath("/html/head/title"));
		//String actual = getTextFromWebelement(textElement, "Home Page ~ Salesforce - Developer Edition");
		if (textElement.isDisplayed()) {
			String Actual = textElement.getText();
			if(Actual.equalsIgnoreCase(expected)) {
				System.out.println("Testcase Passed");
			}
			else {
				System.out.println("Testcase Failed");
			}
		}else {
			System.out.println("Element is not displayed for Salesforce Home page");
		}
	
		driver.close();
	}
		
	}

