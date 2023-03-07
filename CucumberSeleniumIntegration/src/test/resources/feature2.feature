Feature: Calculator App
  
  Scenario Outline: Add two numbers
    Given a as "<A>" and b as "<B>"
    When add the two integer values
    Then Result should be sum of two integers

    Examples: 
      |A|B|
      |100|2|
      |30|35|
      |50|20|