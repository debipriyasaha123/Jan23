package com.SeleniumwithMaven;

import com.jan23base.BaseTest;
import com.jan23.utility.PropertiesUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.jan23.utility.TestEventListenersUtility.class)
public class SalesforceWebpageWithTestNg extends BaseTest{

	@Test (alwaysRun = true)
	public void loginTC02() throws InterruptedException, IOException {
		
		logger.info("Inside login method");
		extentreport.logTestInfo("Inside login method");
		PropertiesUtility propertiesUtility =new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String username=propertiesUtility.getPropertyValue("login.valid.username");
		String password=propertiesUtility.getPropertyValue("login.valid.password");
		String expected = "Salesforce Homepage";
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		//By idLoc = By.id("username");
		//WebElement username = driver.findElement(By.id("username"));
		//enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		//WebElement password = driver.findElement(By.id("password"));
		//enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement textElement = driver.findElement(By.xpath("/html/head/title"));
		//System.out.println("Login done successfully");
		logger.info("Login done successfully");
		String actual = driver.findElement(By.xpath("//a[@title='Home Tab - Selected']")).getText();
		Assert.assertEquals(actual, expected);
		extentreport.logTestInfo("Login done successfully");
		extentreport.logTestInfo("Method ended");
		driver.close();
	}

	@Test (alwaysRun = true)
    public void error_loginTC01 () throws InterruptedException {
		
	String expected = "Please enter your password";
	GetDriverInstance ("chrome");
	GoToUrl("https://www.salesforce.com/login/");
	Thread.sleep(5000);
	By idLoc = By.id("username");
	WebElement username = driver.findElement(By.id("username"));
	enterText (username, "debipriya_1@tekarch.com", "usernameEle");
	WebElement password = driver.findElement(By.id("password"));
	enterText (password, "", "passwordEle");
	driver.findElement(By.id("Login")).click();
	Thread.sleep(5000);
	String actual = driver.findElement(By.id("error")).getText();
	Assert.assertEquals(actual,expected);
	/*if(actual.equalsIgnoreCase(expected)) {
		logger.info("Error_login script passed");
	}
	 else {
		 logger.info("Error_login script failed");
	 }*/
	driver.close();
  }
	@Test (enabled = true)
	 public void wrong_username_passwordTC04 () throws InterruptedException {
			
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator";
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "123", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "22131", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		String actual = driver.findElement(By.id("error")).getText();
		/*if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Error_login script passed");
		}
	     else {
			System.out.println("Error_login script failed");
			}*/
	   Assert.assertEquals(actual, expected);
	   driver.close();
	}
	
	@Test (enabled = true)
	public void usermenue_DropdownTC05() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement usermenue = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		usermenue.click();
		/*Actions action = new Actions(driver);
		action.moveToElement(usermenue).build().perform();
		action.contextClick(usermenue).build().perform();*/ 
		driver.close();
	}
	
	@Test (enabled = true)
	public void myProfile_EditTC06() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement usermenue = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		usermenue.click();
		WebElement myProfile = driver.findElement(By.xpath("//a[@title='My Profile']"));
		myProfile.click();
		/*WebElement userActionMenue = driver.findElement(By.xpath("//a[@id='moderatorMutton']"));
		userActionMenue.click();
		WebElement editProfile = driver.findElement(By.xpath("//a[@title='Edit Profile']"));
		editProfile.click();
		Thread.sleep(4000);
		WebElement frame1 = driver.findElement(By.xpath("//*[@id='aboutMeContentId']"));
		driver.switchTo().frame(frame1);
		WebElement about = driver.findElement(By.xpath("//*[@role='tab' and contains(text(),'About')]"));
		about.click();
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys("Saha");
		Thread.sleep(4000);
		WebElement save = driver.findElement(By.xpath("//*[@value = 'Save All']"));
		save.click();*/
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		WebElement postField = driver.findElement(By.xpath("//span[text()='Post']"));
		postField.click();
		WebElement postFrame = driver.findElement(By.xpath("//*[@title = 'Rich Text Editor, publisherRichTextEditor']"));
		driver.switchTo().frame(postFrame);
		WebElement frameBody = driver.findElement(By.xpath("//html[1]/body[1]"));
		frameBody.click();
		frameBody.sendKeys("Hi, Good morning");
		driver.switchTo().parentFrame();
		Thread.sleep(4000);
		WebElement shareButton = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		shareButton.click();
		System.out.println("Message is postaed");
		Thread.sleep(4000);
		
		driver.quit();
	}

	@Test (enabled = true)
	public void mySettingsTC07() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement usermenue = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		usermenue.click();
		WebElement mySettings = driver.findElement(By.xpath("//a[@title='My Settings']"));
		mySettings.click();
		WebElement personalLink = driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		personalLink.click();
		WebElement loginhistory = driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
		loginhistory.click();
		WebElement displayLayout = driver.findElement(By.xpath("//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('DisplayAndLayout');\"]"));
		displayLayout.click();
		WebElement customizeMyTab = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		customizeMyTab.click();
		WebElement save = driver.findElement(By.xpath("//input[@title='Save']"));
		save.click();
		WebElement email = driver.findElement(By.xpath("//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('EmailSetup');\"]"));
		email.click();
		WebElement myEmailSetting = driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		myEmailSetting.click();
		WebElement EmailName = driver.findElement(By.id("sender_name"));
		if(EmailName.isDisplayed()) {
			EmailName.clear();
			EmailName.sendKeys("Debipriya Saha");
		}else {
			System.out.println("Element is not displayed");
		}
		WebElement EmailAddress = driver.findElement(By.id("sender_email"));
		if(EmailAddress.isDisplayed()) {
			EmailAddress.clear();
			EmailAddress.sendKeys("debipriya.saha123@gmail.com");
		}else {
			System.out.println("Element is not displayed");
		}
		WebElement automaticBCCradiobutton = driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		automaticBCCradiobutton.click();
		WebElement saveButton = driver.findElement(By.xpath("//input[@title='Save']"));
		saveButton.click();
		WebElement CalanderReminders = driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
		CalanderReminders.click();
		WebElement ActivityReminders = driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		ActivityReminders.click();
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test (enabled = true)
	public void developersConsoleTC08() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement usermenue = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		usermenue.click();
		WebElement developresConsole = driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
		developresConsole.click();
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test (enabled = true)
	public void usermenueLogoutTC09() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement usermenue = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		usermenue.click();
		Thread.sleep(4000);
		WebElement usermenueLogout = driver.findElement(By.xpath("//a[@title='Logout']"));
		usermenueLogout.click();
		driver.close();
	}
	
	@Test (enabled = true)
	public void createAccountTC10() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement accountslink = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		accountslink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement newAccount = driver.findElement(By.xpath("//span[@id='createNewLabel']"));
		newAccount.click();
		WebElement AccountLink = driver.findElement(By.xpath("//a[@class='accountMru menuButtonMenuLink']"));
		AccountLink.click();
		Thread.sleep(4000);
		WebElement AccountName = driver.findElement(By.id("acc2"));
		AccountName.sendKeys("Debi_1");
		WebElement AccountTypeDropdown = driver.findElement(By.id("acc6"));
		selectByIndexData(AccountTypeDropdown, 5 ,"ob");
		//Select ob = new Select(AccountTypeDropdown);
		//ob.selectByIndex(5);
		WebElement CustomerPriority = driver.findElement(By.id("00NDn00000SjaNq"));
		selectByValueData(CustomerPriority, "High", "ob1");
		//Select ob1 = new Select(CustomerPriority);
		//ob1.selectByValue("High");
		WebElement SaveButton2 = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		SaveButton2.click();
		Thread.sleep(4000);
		driver.close();
	}
	@Test (enabled = true)
	public void Account_viewTC11() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement accountslink = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		accountslink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement creatNewView = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		creatNewView.click();
		WebElement ViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		ViewName.sendKeys("Debi");
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='fname']"));
		ViewUniqueName.sendKeys("Debi");
		WebElement SaveButton = driver.findElement(By.xpath("//input[@id='fname']"));
		SaveButton.click();
		
		driver.close();
	}
	@Test (enabled = true)
	public void Account_Edit_viewTC12() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement accountslink = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		accountslink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement EditButton = driver.findElement(By.xpath("//a[normalize-space()='Edit']"));
		EditButton.click();
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='fname']"));
		ViewUniqueName.sendKeys("Debi");
		WebElement FieldDropdown = driver.findElement(By.xpath("//select[@id='fcol1']"));
		Select ob1 = new Select(FieldDropdown);
		ob1.selectByVisibleText("Account Name");
		WebElement OperatorDropdown = driver.findElement(By.xpath("//select[@id='fop1']"));
		Select ob2 = new Select(OperatorDropdown);
		ob2.selectByVisibleText("contains");
		WebElement Value = driver.findElement(By.xpath("//input[@id='fval1']"));
		Value.sendKeys("a");
		WebElement SaveButton2 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		SaveButton2.click();
		driver.close();
	}
	@Test (enabled = true)
	public void Merge_AccountTC13() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement accountslink = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		accountslink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement mergeAccount = driver.findElement(By.xpath("//a[normalize-space()='Merge Accounts']"));
		mergeAccount.click();
		WebElement findAccount = driver.findElement(By.xpath("//input[@id='srch']"));
		findAccount.sendKeys("Debi_1");
		WebElement findAccountButton = driver.findElement(By.xpath("//input[@name='srchbutton']"));
		findAccountButton.click();
		WebElement selectField1 = driver.findElement(By.xpath("//input[@id='cid0']"));
		selectField1.click();
		WebElement selectField2 = driver.findElement(By.xpath("//input[@id='cid1']"));
		selectField2.click();
		Thread.sleep(4000);
		WebElement nextButton = driver.findElement(By.xpath("//input[@title='Next']"));
		nextButton.click();
		driver.close();
	}
	@Test (enabled = true)
	public void Account_ReportTC14() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement accountslink = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		accountslink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement lastActivity = driver.findElement(By.xpath("//a[normalize-space()='Accounts with last activity > 30 days']"));
		lastActivity.click();
		//WebElement popup3 = driver.findElement(By.id("ext-gen189"));
		//popup3.click();
		//Thread.sleep(4000);
		WebElement fromFieldDropdown = driver.findElement(By.xpath("//*[@id='ext-gen152']"));
		fromFieldDropdown.click();
		WebElement selectDate = driver.findElement(By.xpath("//button[@id='ext-gen276']"));
		selectDate.click();
		Thread.sleep(4000);
		WebElement RunReport = driver.findElement(By.xpath("//button[@id='ext-gen63']"));
		RunReport.click();
		driver.close();
	}
	
	@Test (enabled = true)
	public void Opportunity_DropdownTC15() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement OpportunityView = driver.findElement(By.xpath("//select[@id='fcf']"));
		OpportunityView.click();
		Thread.sleep(4000);
		driver.close();
	}
	@Test (enabled = true)
	public void Opportunity_CreateNewTC16() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement OpportunityCreateNew = driver.findElement(By.xpath("//input[@title='New']"));
		OpportunityCreateNew.click();
		Thread.sleep(4000);
		WebElement OpportunityName = driver.findElement(By.xpath("//input[@id='opp3']"));
		OpportunityName.sendKeys("Testing");
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='opp4']"));
		AccountName.sendKeys("Debi_1");
		Thread.sleep(4000);
		WebElement LeadSource = driver.findElement(By.xpath("//select[@id='opp6']"));
	    Select ob5 = new Select(LeadSource);
	    ob5.selectByVisibleText("Web");
	    WebElement CloseDate = driver.findElement(By.xpath("//a[normalize-space()='2/11/2023']"));
		CloseDate.click();
		Thread.sleep(4000);
		WebElement Stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Select ob6 = new Select(Stage);
	    ob6.selectByVisibleText("Needs Analysis");
	    WebElement Probability = driver.findElement(By.xpath("//input[@id='opp12']"));
		Probability.clear();
		Probability.sendKeys("20");
		WebElement PrimaryCampaignSource = driver.findElement(By.xpath("//input[@id='opp17']"));
		PrimaryCampaignSource.sendKeys("*");
		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		SaveButton.click();
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test (enabled = true)
	public void Opportunity_PipelineTC17() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement OpportunityPipeline = driver.findElement(By.xpath("//a[normalize-space()='Opportunity Pipeline']"));
		OpportunityPipeline.click();
	    driver.close();   
	}
	@Test (enabled = true)
	public void Opportunity_StuckTC18() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement StuckOpportunities = driver.findElement(By.xpath("//a[normalize-space()='Stuck Opportunities']"));
		StuckOpportunities.click();
		Thread.sleep(4000);
	    driver.close();   
	}
	
	@Test (enabled = true)
	public void QuarterlySummeryTC19() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		//WebElement SummeryInterval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		//Select ob3 = new Select(SummeryInterval);
	    //ob3.selectByVisibleText("Current and NextFQ");
	    WebElement SummeryInclude = driver.findElement(By.xpath("//select[@id='open']"));
		Select ob4 = new Select(SummeryInclude);
	    ob4.selectByVisibleText("All Opportunities");
	    Thread.sleep(4000);
	    WebElement RunReport = driver.findElement(By.xpath("//a[normalize-space()='Stuck Opportunities']"));
		RunReport.click();
		Thread.sleep(5000);
	    driver.close();   
	}
	
	@Test (enabled = true)
	public void LeadsTabTC20() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(5000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement LeadsTabPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
	    LeadsTabPage.click();
		Thread.sleep(4000);
	    driver.close();   
	}
	
	@Test (enabled = true)
	public void OpenLeadsTabTC21() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement LeadsTabPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
	    LeadsTabPage.click();
		WebElement LeadsView = driver.findElement(By.xpath("//select[@id='fcf']"));
	    LeadsView.click();
		Thread.sleep(4000);
	    driver.close();   
	}
	
	@Test (enabled = true)
	public void ChangeLeadsTabTC22() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement LeadsTabPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
	    LeadsTabPage.click();
		WebElement LeadsView = driver.findElement(By.xpath("//select[@id='fcf']"));
	    Select ob4 = new Select (LeadsView);
	    ob4.selectByVisibleText("My Unread Leads");
		Thread.sleep(4000);
		WebElement UsermenueDropdown = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		UsermenueDropdown.click();
		Thread.sleep(4000);
		WebElement Logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		Logout.click();
		Thread.sleep(4000);
		By idLoc1 = By.id("username");
		WebElement username1 = driver.findElement(By.id("username"));
		enterText (username1, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password1 = driver.findElement(By.id("password"));
		enterText (password1, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement LeadsTabPage1 = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
	    LeadsTabPage1.click();
	    WebElement clickGo = driver.findElement(By.xpath("//input[@title='Go!']"));
	    clickGo.click();
	    Thread.sleep(6000);
		driver.close();   
	}
	
	@Test (enabled = true)
	public void TodaysLeadsTabTC23() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement LeadsTabPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
	    LeadsTabPage.click();
		WebElement LeadsView = driver.findElement(By.xpath("//select[@id='fcf']"));
	    Select ob4 = new Select (LeadsView);
	    ob4.selectByVisibleText("Today's Leads");
		Thread.sleep(4000);
		WebElement clickGo = driver.findElement(By.xpath("//input[@title='Go!']"));
		clickGo.click();
	    Thread.sleep(6000);
		driver.close();   
	}
	
	@Test (enabled = true)
	public void NewLeadsTabTC24() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement LeadsTabPage = driver.findElement(By.xpath("//*[@id='Lead_Tab']"));
	    LeadsTabPage.click();
		WebElement clickNew = driver.findElement(By.xpath("//input[@title='New']"));
		clickNew.click();
		WebElement LastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		LastName.sendKeys("ABCD");
		WebElement CompanyName = driver.findElement(By.xpath("//input[@id='lea3']"));
		CompanyName.sendKeys("ABCD");
		Thread.sleep(4000);
		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		SaveButton.click();
	    Thread.sleep(6000);
		driver.close();   
	}
	
	@Test (enabled = true)
	public void ContactsTabTC25() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement ContactsTab = driver.findElement(By.xpath("//a[@title='Contracts Tab']"));
	    ContactsTab.click();
	    WebElement clickNew = driver.findElement(By.xpath("//input[@title='New']"));
		clickNew.click();
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='ctrc7']"));
		AccountName.sendKeys("AccountName");
		Thread.sleep(4000);
		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		SaveButton.click();
	    Thread.sleep(6000);
		driver.close();   
	}
	
	@Test (enabled = true)
	public void CtreateNewContactsTC26() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement ContactsTab = driver.findElement(By.xpath("//a[@title='Contracts Tab']"));
	    ContactsTab.click();
	    WebElement CreateNewView = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		CreateNewView.click();
		WebElement ViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		ViewName.sendKeys("VIEw Name");
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		ViewUniqueName.sendKeys("VIEw Unique Name");
		Thread.sleep(6000);
		WebElement SaveButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		SaveButton.click();
	    Thread.sleep(6000);
		driver.close();   
	}
	
	@Test (enabled = true)
	public void RecentlyCreatedTC27() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
	    WebElement AllTabs = driver.findElement(By.xpath("//img[@title='All Tabs']"));
	    AllTabs.click();
	    Thread.sleep(4000);
	    WebElement ContactTab = driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']"));
	    ContactTab.click();
	    Thread.sleep(4000);
	    WebElement RecentlyCreatedTab = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
	    RecentlyCreatedTab.sendKeys("Recently Created");
	    Thread.sleep(4000);
	    driver.close();   
	}	
	
	@Test (enabled = true)
	public void MyContactsTC28() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
	    WebElement AllTabs = driver.findElement(By.xpath("//img[@title='All Tabs']"));
	    AllTabs.click();
	    Thread.sleep(4000);
	    WebElement ContactTab = driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']"));
	    ContactTab.click();
	    //WebElement ViewTab = driver.findElement(By.xpath("//*[@value='00BDn00000ImMxF']"));
	    //ViewTab.sendKeys("My Contacts");
	    //WebElement GoTab = driver.findElement(By.xpath("//input[@value=' Go! ']"));
	    //GoTab.click();
	    Thread.sleep(6000);
	    driver.close();
	}
	

	@Test (enabled = true)
	public void ViewContactsTC29() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(4000);
		WebElement AllTabs = driver.findElement(By.xpath("//img[@title='All Tabs']"));
	    AllTabs.click();
	    WebElement ContactTab = driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']"));
	    ContactTab.click();
	    WebElement ViewTab = driver.findElement(By.xpath("//select[@id='fcf']"));
	    ViewTab.sendKeys("All Contacts");
	    Thread.sleep(4000);
	    WebElement FirstContact = driver.findElement(By.xpath("//a[normalize-space()='Gonzalez, Rose']"));
	    FirstContact.click();
	    Thread.sleep(6000);
	    driver.close();
	}
	
	@Test (enabled = true)
	public void ContactErrorMassegeTC30() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement ContactsTab = driver.findElement(By.xpath("//a[@title='Contracts Tab']"));
	    ContactsTab.click();
	    WebElement CreateNewView = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		CreateNewView.click();
        Thread.sleep(4000);
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		ViewUniqueName.sendKeys("EFGH");
		Thread.sleep(6000);
		WebElement SaveButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		SaveButton.click();
	    Thread.sleep(6000);
		driver.close();   
	}	
	
	@Test (enabled = true)
	public void CreateContactCancleTC31() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
	    WebElement ContactsTab = driver.findElement(By.xpath("//a[@title='Contracts Tab']"));
	    ContactsTab.click();
	    WebElement CreateNewView = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		CreateNewView.click();
        Thread.sleep(4000);
    	WebElement ViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		ViewName.sendKeys("ABCD");
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		ViewUniqueName.sendKeys("EFGH");
		Thread.sleep(6000);
		WebElement CancelButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
		CancelButton.click();
	    Thread.sleep(6000);
		driver.close();   
	}	
	
	@Test (enabled = true)
	public void NewContactPageTC32() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Opportunitylink = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Opportunitylink.click();
		Thread.sleep(4000);
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
		WebElement AllTabs = driver.findElement(By.xpath("//img[@title='All Tabs']"));
	    AllTabs.click();
	    WebElement ContactTab = driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']"));
	    ContactTab.click();
	    WebElement NewTab = driver.findElement(By.xpath("//input[@title='New']"));
	    NewTab.click();
	    WebElement LastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		LastName.sendKeys("Indian");
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='con4']"));
		ViewUniqueName.sendKeys("Global Media");
		WebElement Save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
	    Save.click();
	    Thread.sleep(5000);
	    driver.close();
	} 
	
	@Test (enabled = true)
	public void HomeTabTC33() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Homelink = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		Homelink.click();
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
		WebElement ClickName = driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Debipriya Saha']"));
		ClickName.click();
		Thread.sleep(5000);
	    driver.close();
		
	}	
  
	@Test (enabled = true)
	public void HomeTabEditProfileTC34() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Homelink = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		Homelink.click();
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
		WebElement ClickName = driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Debipriya Saha']"));
		ClickName.click();
		WebElement EditProfile = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		EditProfile.click();
		Thread.sleep(5000);
	    driver.close();
		
	}	
	
	@Test (enabled = true)
	public void RemoveTabTC35() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement AllTab = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		AllTab.click();
		WebElement CustomizeMyTab = driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		CustomizeMyTab.click();
		WebElement SelectTab = driver.findElement(By.xpath("//option[@value='Workspace']"));
	    SelectTab.click();
	    WebElement RemoveTab = driver.findElement(By.xpath("//img[@title='Remove']"));
	    RemoveTab.click();
	    WebElement Save = driver.findElement(By.xpath("//input[@title='Save']"));
	    Save.click();
	    WebElement UsermenueDropdown = driver.findElement(By.xpath("//*[@id = 'userNavLabel']"));
		UsermenueDropdown.click();
		Thread.sleep(4000);
		WebElement Logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		Logout.click();
		Thread.sleep(4000);
		By idLoc1 = By.id("username");
		WebElement username1 = driver.findElement(By.id("username"));
		enterText (username1, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password1 = driver.findElement(By.id("password"));
		enterText (password1, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		WebElement AllTab1 = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		AllTab1.click();
		WebElement CustomizeMyTab1 = driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		CustomizeMyTab1.click();
		Thread.sleep(6000);
	    driver.close();
		
	}
	
	@Test (enabled = true)
	public void HomeTabTC36() throws InterruptedException {
		
		GetDriverInstance ("chrome");
		GoToUrl("https://www.salesforce.com/login/");
		Thread.sleep(4000);
		By idLoc = By.id("username");
		WebElement username = driver.findElement(By.id("username"));
		enterText (username, "debipriya_1@tekarch.com", "usernameEle");
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, "tuktuki123", "passwordEle");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		WebElement Homelink = driver.findElement(By.xpath("//a[@title='Home Tab']"));
		Homelink.click();
		WebElement popup1 = driver.findElement(By.id("lexNoThanks"));
		popup1.click();
		WebElement popup2Cancle = driver.findElement(By.id("tryLexDialogX"));
		popup2Cancle.click();
		Thread.sleep(6000);
		WebElement CurrentDate = driver.findElement(By.xpath("//a[normalize-space()='Sunday February 12, 2023']"));
		CurrentDate.click();
		WebElement TimeClick = driver.findElement(By.xpath("//a[normalize-space()='8:00 PM']"));
		TimeClick.click();		
		WebElement Save = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		Save.click();
		Thread.sleep(6000);
	    driver.close();	
	    driver.quit();
	}
	
	
}
	







