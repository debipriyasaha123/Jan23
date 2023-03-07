package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		
		features = {"src/test/resources/salesforcefeature.feature"},
		glue = {"com.step.StepDefinitionForSalesforce"},
		dryRun = false
		//plugin = {"pretty", "html:target/cucumber.html", "jason:target/cucumber"}		
		
		)

public class RunnerForSalesforce extends AbstractTestNGCucumberTests {

}
