@DummyApi2
Feature: Tesing the api https://dummy.restapiexample.com/api/v1


Scenario: Get list of all employees
When I want to retrive all the information about the employees using get http method and '<URI>'
Then I should get the data along with success status code

Examples:
|URI|
|https://dummy.restapiexample.com/api/v1|

#Scenario: Create new employee in the data base
#When I want to create a new employee data in the database
#Then new employee data should be created in the database with success status code





