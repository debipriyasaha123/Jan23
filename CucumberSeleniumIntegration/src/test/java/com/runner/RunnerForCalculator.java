package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//Background: 
//Given two integer values in the application


@CucumberOptions(
		
	features= {"src/test/resources/simplefeature.feature"},
	glue= {"com.step"},
//glue represents corresponding features of step definition feature files
	monochrome = true,
	dryRun = false,
	plugin = {"pretty", "html:targer/cucumber.html", "json:target/cucumber.json"},
	tags = "@test1"
			
		)

public class RunnerForCalculator extends AbstractTestNGCucumberTests{

//each & every scenerios in feature file are considerd as seperate test
//cucumber hooks => @Before, @BeforeAll, @BeforeStep
	       //and => @After, @AfterAll, @AfterStep
}
