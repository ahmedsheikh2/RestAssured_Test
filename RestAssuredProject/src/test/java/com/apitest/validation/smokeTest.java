package com.apitest.validation;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import org.testng.annotations.*;

import com.api.test.resource.addPetResource;
import com.api.test.resource.findPetResources;
import com.utils.methods.ReusableMethods;

import org.apache.logging.log4j.*;


public class smokeTest {
	
	public static Logger log = LogManager.getLogger(smokeTest.class.getName());
	Headers headers = new Headers();
	Properties prop = new Properties();

@BeforeTest
public void initialSetup() throws IOException {
	
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//global.properties");
	prop.load(fis);
     
	RestAssured.baseURI = prop.getProperty("BASE_URL");

	headers = ReusableMethods.getHeader();
	log.info("Initial Setup Completed");
}


@Test(dataProvider = "testData", priority=1) 
public void addPet(int id, String name) {
	
	log.info("Add Pet By Status Test Case Started");
	
	Response res = given()
			.headers(headers)
			.body(addPetResource.getPetDataJSON(id , name))
			.when()
			.post(addPetResource.getAddPetResource())
			.then().statusCode(200)
			.extract().response();
		  	
		    JsonPath response = ReusableMethods.rawToJson(res);
		  
		    assertThat(response.get("id")).isEqualTo(id);
		    assertThat(response.get("name")).isEqualTo(name);
		    
		    log.info("Add Pet Test Case has Passes Successfully");
}


@Test(priority=2)
public void findPetByid() {
	
	log.info("Find Pet Test Case Started");
	
	Response res = given()
			.when()
			.get(findPetResources.getPetByIdResource(prop.getProperty("ID")))
			.then().statusCode(200)
			.extract().response();
		  	
		    JsonPath response = ReusableMethods.rawToJson(res);
		  
		    assertThat(response.get("name")).isEqualTo(prop.getProperty("NAME"));
		    assertThat(response.get("status")).isEqualTo(prop.getProperty("STATUS")); 
		    
		    log.info("Find Pet Test Case has Passes Successfully");
}

@Test(priority=3)
public void deletePetByid() {
	
	log.info("Delete Pet Test Case Started");
	
	Response res = given()
			.when()
			.delete(findPetResources.getPetByIdResource(prop.getProperty("ID")))
			.then().statusCode(200)
			.extract().response();
		  	
		    JsonPath response = ReusableMethods.rawToJson(res);
		  
		    assertThat(response.get("type")).isEqualTo("unknown");
		    assertThat(response.get("code")).isEqualTo(200); 
		    
		    log.info("Delete Pet Test Case has Passes Successfully");
}
	
@Test(priority=4)
public void findPetByStatus() {
	
	log.info("Find Pet By Status Test Case Started");
	
	Response res = given()
			.queryParam("status", prop.getProperty("STATUS"))
			.when()
			.get(findPetResources.getPetByStatusResource())
			.then().statusCode(200)
			.extract().response();
		  
		    JsonPath response = ReusableMethods.rawToJson(res);
		  
		    assertThat(response.get("status[0]")).isEqualTo(prop.getProperty("STATUS"));
		    
		    log.info("Find Pet By Status Test Case has Passes Successfully");
}

		 
	@DataProvider(name = "testData")
	public Object[][] getData() {
		return new Object[][] { { 50013, "assignmentPet"},{ 50014, "assignmentPet2" } };
	}

}