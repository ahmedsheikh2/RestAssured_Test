package com.utils.methods;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class utilsMethods {
	
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
	
    public static Headers getHeader() {
    	
    	Header accept = new Header("accept", "application/json");
		Header contentType = new Header("Content-Type","application/json");
    	Headers header = new Headers(accept, contentType);
    	
    	return header;
    }	
 

}
