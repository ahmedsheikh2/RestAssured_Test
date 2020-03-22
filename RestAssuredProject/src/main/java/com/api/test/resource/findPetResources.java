package com.api.test.resource;

public class findPetResources {

	public static String getPetByStatusResource()
	{
		String res="/v2/pet/findByStatus";
		return res;
	}
	
	public static String getPetByIdResource(String id)
	{
		String res="/v2/pet/" + id;
		return res;
	}
	
}
