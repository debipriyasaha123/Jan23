package com.FireBase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		
		features = {"src/test/resources/salesforcefeature.feature"}
		
		)
	
public class runnerForSalesaforce extends AbstractTestNGCucumberTests {

}
