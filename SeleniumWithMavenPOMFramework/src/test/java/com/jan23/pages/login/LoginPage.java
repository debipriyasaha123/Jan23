package com.jan23.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jan23.pages.home.HomePage;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement Username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//div[@id='error']")
	WebElement ErrorMessage;
	@FindBy(xpath = "//*[@id='Iogin']")
	WebElement LoginButton;
	@FindBy(xpath = "//*[@id='RememberUn']")
	WebElement remember;
	@FindBy(xpath = "//*[@id='forgot_password_link']")
	WebElement ForgotPassword ;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement LogoutButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginButton.click();
		return new HomePage();
	}
	
	public void ErrorMessage(String ermsg) {
		ErrorMessage.sendKeys(ermsg);
	}

	public void clickLogout(String data) {
		LogoutButton.click();
	}
	
}
