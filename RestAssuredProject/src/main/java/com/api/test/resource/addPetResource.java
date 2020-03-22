package com.api.test.resource;

public class addPetResource {
	
	public static String getAddPetResource()
	{
		String res="/v2/pet";
		return res;
	}
	
	public static String getPetDataJSON(int id, String name)
	{
		String idd = Integer.toString(id);
		String res = "{\r\n" + 
				"  \"id\": "+idd+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+ name +"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}";
		return res;
	}
}