Feature: Validating the Place API's

@AddPlace @Regression
Scenario Outline: Verify that user is able to add he place in an API
Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlace" API for "POST" http request
Then API calls successful with status code as 200
And the "status" in response is "OK"
And verify place_ID created maps to "<name>" using "GetPlace" API

Examples:
		|name    |language |address |
		|mohit   |English  |Kanpur  |
		|rohit   |German   |Delhi   |
		|Aneesha |Hindi	   |Lion	|
		

@DeletePlace @Regression
Scenario: Verify if deletePlace API works
Given DeletePlace payload
When user calls "DeletePlace" API for "POST" http request
Then API calls successful with status code as 200
And the "status" in response is "OK"		 