package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuilder {
	
	public AddPlace AddPlaceAPI(String name, String language, String address)
	{
		AddPlace a= new AddPlace();
		a.setAccuracy(50);
		a.setName(name);
		a.setAddress(address);
		a.setLanguage(language);
		a.setWebsite("https://www.google.com");
		a.setPhone_number("9090909090");
		List<String> myList= new ArrayList<String>();
		myList.add("Test");
		myList.add("Me");
		a.setTypes(myList);
		Location l= new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		
		return a;
	}
	
	public String deletePlaceAPI(String placeID)
	{
		return "{\r\n\t\"place_id\": \""+placeID+"\"\r\n}";
	}

}
