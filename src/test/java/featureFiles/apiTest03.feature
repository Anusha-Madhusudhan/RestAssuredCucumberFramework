#Using the provide REST service, create a program that returns, at minimum, capital city based on user input for name or code.
#Write several tests that validate positive and negative scenario’s

# https://restcountries.com/v3.1/alpha/{code}
# https://restcountries.com/v3.1/name/{name}

@API3
Feature: Tesing the api "https://restcountries.com/v3.1/name/{name}" which returns the info of country name

Scenario Outline: Test the API by sending full country name
When I enter the full name <CountryName> of the country and hit the get https request
Then I should get the information about the country

Examples:
|CountryName|
|'India'|
#|'Germany'|
#|'United States'|
#|'China'|
#|'Japan'|
