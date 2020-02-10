package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;
import stepDefinations.stepDefination;
public class Hooks {
	
	@Before("@DeletePlace")
	public void BeforeScenario() throws IOException
	{
		stepDefination m= new stepDefination();
		
		if(stepDefination.place_id==null)
		{
			
		m.add_Place_Payload_with("Mohit", "French", "Palk street");
		m.user_calls_API_for_http_request("AddPlace", "POST");
		m.verify_place_ID_created_maps_to_using_API("Mohit", "GetPlace");
		
		}
	}

}
