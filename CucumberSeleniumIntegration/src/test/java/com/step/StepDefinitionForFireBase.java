package com.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionForFireBase {

	WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.close();
	}
	
	@Given("application is up and running and in loginpage")
	public void application_is_up_and_running_and_in_loginpage() {
		 
		  driver.get("https://qa-tekarch.firebaseapp.com/");
		  driver.manage().window().maximize();
	}
	@When("i enter username and password")
	public void i_enter_username_and_password() throws InterruptedException {
		Thread.sleep(5000);
		By idLoc=By.id("email_field");
		WebElement username= driver.findElement(idLoc);
		username.sendKeys("admin123@gmail.com");
		WebElement password=driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");  
	}
	@When("click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.tagName("button")).click(); 
	}
	@Then("i should get the home page")
	public void i_should_get_the_home_page() throws InterruptedException {
		String expected="Student Registration Form";
		Thread.sleep(5000);
		WebElement textElement=driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
		String actaul=textElement.getText();
		Assert.assertEquals(actaul, expected);
	}

	@When("i enter username and wrong password")
	public void i_enter_username_and_wrong_password() throws InterruptedException {
		Thread.sleep(5000);
		By idLoc=By.id("email_field");
		WebElement username= driver.findElement(idLoc);
		username.sendKeys("admin123@gmail.com");
		WebElement password=driver.findElement(By.id("password_field"));
		password.sendKeys("123");  
	}
	
	@Then("i should get the error message")
	public void i_should_get_the_error_message() {
	   
	}
}