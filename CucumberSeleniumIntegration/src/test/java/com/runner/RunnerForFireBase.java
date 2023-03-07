package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/firebasefeature.feature"},
		glue= {"com.step"}
		)

public class RunnerForFireBase extends AbstractTestNGCucumberTests {

}