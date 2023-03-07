Feature: Calculator app
@test1
 Scenario: Add two numbers
 Given two integer values in the application
 When add the two integer values
 Then Result should be sum of two integers
 @smoke
 Scenario: Add two numbers
 Given a as 100 and b as 2
 When add the two integer values
 Then Result should be sum of two integers
 @test1
 Scenario: Add two numbers
 Given x and y values for calculator
 When add the two integer values
 Then Result should be sum of two integers
