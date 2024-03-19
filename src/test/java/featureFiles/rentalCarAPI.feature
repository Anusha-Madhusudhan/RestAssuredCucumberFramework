@RentalCarAPI
Feature: Validating Rental Car API Response

Scenario:GET car information
When I hit the api to fetch the rental car information using get http request method
Then I shoul get the response with required information along with success status code


Scenario:Post car information
When I hit the api to add new rental car information using post http request method
Then I should be able to add new car info to DB  along with success status code


