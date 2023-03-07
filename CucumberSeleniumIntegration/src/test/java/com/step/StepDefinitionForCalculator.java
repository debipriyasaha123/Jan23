package com.step;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionForCalculator {
	
	int a,b;
	int result;
	
	@Given("^two integer values$") //Regular Expresion [starts with ^ and ends with $]
	public void two_integer_values() {
	  a=10;
	  b=20;
	}

	@When("add the two integer values") //Cucumber Expresion
	public void add_the_two_integer_values() {
		result = a+b;
	}

	@Then("Result should be sum of two integers")
	public void result_should_be_sum_of_two_integers() {
	    System.out.println("Result = "+ result);
	}
	
	@Given("two integer values in the application")
	public void two_integer_values_in_the_application() {
	   a=10;
	   b=20;
	}
	
	@When("subtract the two integer values")
	public void subtract_the_two_integer_values() {
		result = a-b;
	}

	@Then("Result should be difference of two integers")
	public void result_should_be_difference_of_two_integers() {
		System.out.println("Result = "+ result);
	}
	

    @When("multiply the two integer values")
    public void multiply_the_two_integer_values() {
    	result = a*b;
    }

    @Then("Result should be multiply of two integers")
    public void result_should_be_multiply_of_two_integers() {
    	System.out.println("Result = "+ result); 
   }
    
    @Given("a as {string} and b as {string}")
    public void a_as_and_b_as(String val1, String val2) {
    	a = Integer.parseInt(val1);
    	b = Integer.parseInt(val2);
  
    }

    @Given("^a as (\\d+) and b as (\\d+)$")
    public void a_as_and_b_as(Integer val1, Integer val2) {
     a = val1;
     b = val2;
    }	
	
   /* @Given("a as {int} and b as {int}")
    public void a_as_and_b_as_a(Integer int1, Integer int2) {
     a = int1;
     b = int2;
    }*/
    
    @Given("x and y values for calculator")
    public void x_and_y_values_for_calculator() {
       a=10;
 	   b=20; 
    }

}
