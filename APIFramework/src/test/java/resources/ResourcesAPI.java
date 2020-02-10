package resources;

public enum ResourcesAPI {
	AddPlace("/maps/api/place/add/json"),
	GetPlace("/maps/api/place/get/json"),
	DeletePlace("/maps/api/place/delete/json");
	
	private String resource;
	
	ResourcesAPI(String resource)
	{
		this.resource= resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
