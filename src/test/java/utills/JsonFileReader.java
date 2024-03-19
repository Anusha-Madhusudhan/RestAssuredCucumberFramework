/**
 * 
 */
package utills;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

/**
 * Find value of username
Find values of all sessionid
Find last value of sessionid
Find all marks of second student
Find the ssecond state value of first student
Find the ssecond contact value of second student
Find all cities of second student
Find contacts of all students
Find adress of first student
 */
public class JsonFileReader {
	
	
	
//	@Test
	public static void readStudentsJsonFile(){
		File studentsFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\students.json");
		JsonPath jp=new JsonPath(studentsFile);
		
		System.out.println("User Name "+jp.getString("username"));
		
		System.out.println("Session Ids "+jp.getString("sessionid"));
		
		System.out.println("Last value of session ID "+jp.getString("sessionid[3]"));
		
		System.out.println("Marks of Second Student "+jp.getString("students[1].marks"));
		
		System.out.println("2nd state of Second Student "+jp.getString("students[1].adresss[1].state"));
		
		System.out.println("all the cities of Second Student "+jp.getString("students[1].adresss[1].city")+" "+jp.getString("students[1].adresss[0].city"));
		
		System.out.println(jp.getString("students[0].contact")+"   "+jp.getString("students[1].contact"));
	}
	
	
//	@Test
	public void parsingDynamicJson() throws IOException {
		String studentsFile=System.getProperty("user.dir")+"\\src\\test\\resources\\India.json";
		
		String jsonString=new String(Files.readAllBytes(Paths.get(studentsFile)),StandardCharsets.UTF_8);
		
		JsonNode jsonNode=new ObjectMapper().readTree(jsonString); // First get the response and check whether it is array or object.
		
		String key="name";
		
		if(jsonNode.isArray()) {
			System.out.println("Response is Array");
			JSONArray jsonArray=new JSONArray(jsonString);
			for(int i=0;i<jsonArray.length();i++) {
				JSONObject jo=jsonArray.getJSONObject(i);
				
				getValue(jo,key);
			}
		}
		else if(jsonNode.isObject()) {
			System.out.println("REsponse is Object");
			
			JSONObject jo=new JSONObject(jsonString);
			
			getValue(jo,key);
			
		}
		
		
		
		
		
	}


	private void getValue(JSONObject jo, String key) {
		
		if(jo.has(key)) {
			System.out.println(jo.get(key));
		}
		else {
		Set<String> keys=jo.keySet();
		
		for(String sKey:keys) {
			

			if(jo.get(sKey) instanceof JSONObject) {
				getValue(jo.getJSONObject(sKey),key);
			}
			else if(jo.get(sKey) instanceof JSONArray) {
				
				JSONArray jsonArray=jo.getJSONArray(sKey);
				
				
				getJsonObject(jsonArray,key);
				
				
			}

		}
		}
		
	}
	
	
	 void getJsonObject(JSONArray jsonAry,String key) {
		for(int i=0;i<jsonAry.length();i++) {
			
			
			if(jsonAry.get(i) instanceof JSONArray) {
				getJsonObject(jsonAry.getJSONArray(i),key);
			}
			else if(jsonAry.get(i) instanceof JSONObject){
				
				getValue(jsonAry.getJSONObject(i),key);
			}
		
		}
	}

}
