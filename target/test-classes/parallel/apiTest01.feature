#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@DummyApi1
Feature: Testing Rest Api https://jsonplaceholder.typicode.com/

 
  #Scenario: Data Upload to a web service
    #When users upload data on a project
    #Then the server should handle it and return a success status

Scenario: Data retrieval from a web service using Get Http method ONE
When users want to get information about user id '4' 
Then the requested data is returned with success status code


#Scenario Outline: Data retrieval from a web service using Get Http method TWO
#When users want to get information about user id '<id>' 
#Then the requested data is returned with success status code
#
#Examples:
#|id|
#|5|
#|8|
#|10|

Scenario: Creating  New User in the database
When I want to create a new user in the data base
Then the new user should get created in DB and I get success status code

#Scenario: Deleting  a User from the database
#When I want to delete a new user in the data base
#Then the  user should get deleted from DB and I get success status code
#
#Scenario: Retriving all users from the data base
#When I want to retrive all the users from the DB
#Then all the users data should returned with success status code
#
#Scenario: Validate the UserId present in the data base
#When I hit the URI for retriving the information about the UserId '7' using GET request
#Then I should get all the information about the user along with the success code in the response


