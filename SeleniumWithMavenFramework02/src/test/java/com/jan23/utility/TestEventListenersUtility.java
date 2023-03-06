package com.jan23.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.jan23.utility.ExtentReportsUtility;

import com.jan23base.BaseTest;

public class TestEventListenersUtility implements ITestListener{

	protected static ExtentReportsUtility extentreport = ExtentReportsUtility.getInstance();
	protected WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
	//before each test start
		extentreport.startSingleTestReport(result.getMethod().getMethodName());
		System.out.println("on test start listener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentreport.logTestpassed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentreport.logTestFailed(result.getMethod().getMethodName());
		BaseTest ob = new BaseTest();
		//driver = ob.returnDriverInstance();
		String path = ob.getScreenShotOfThePage(driver);
		extentreport.logTestScreenshot(path);
	}

	@Override
	public void onStart(ITestContext context) {
	//before all test start	
		extentreport = ExtentReportsUtility.getInstance();
		extentreport.startExtentReport();
		System.out.println("inside onStart listener");
	}

	@Override
	public void onFinish(ITestContext context) {
	//after all test end	
		extentreport.endReport();
	}

	
}
