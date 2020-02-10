package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.ResourcesAPI;
import resources.TestDataBuilder;
import resources.Utils;

public class stepDefination extends Utils {

	
	ResponseSpecification r;
	RequestSpecification res;
	Response resp;
	TestDataBuilder data= new TestDataBuilder();
	static String place_id;
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		 res=given().spec(ResourceSpecification()).
		body(data.AddPlaceAPI(name, language, address));
	}

	@When("user calls {string} API for {string} http request")
	public void user_calls_API_for_http_request(String resource, String method) {
		 ResourcesAPI resAPI=ResourcesAPI.valueOf(resource);
		 resAPI.getResource();
	    
		 if(method.equalsIgnoreCase("POST"))
		resp= res.when().post(resAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			resp= res.when().get(resAPI.getResource());
			
	}

	@Then("API calls successful with status code as {int}")
	public void api_calls_successful_with_status_code_as(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(resp.getStatusCode(), 200);
		
	}

	@Then("the {string} in response is {string}")
	public void the_in_response_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
	  assertEquals(getJson(resp,key), value);
		
	}
	@Then("verify place_ID created maps to {string} using {string} API")
	public void verify_place_ID_created_maps_to_using_API(String expectedName, String resource) {
		place_id= getJson(resp, "place_id");
	     res=given().spec(res).queryParam("place_id", place_id);
	     user_calls_API_for_http_request(resource,"GET");
	     String Actualname=getJson(resp,"name");
	     assertEquals(Actualname, expectedName);
	     
	   
	}
	@Given("DeletePlace payload")
	public void deleteplace_payload() throws IOException {
		
		res=given().spec(ResourceSpecification()).
				body(data.deletePlaceAPI(place_id));
				
	}

	
}
