/**
 * 
 */
package utills;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestPayloads.Employee;
import requestPayloads.RentalCar;
import requestPayloads.User;

/**
 * 
 */
public class RequestMethods {

	public static Response getUserInfo(String userId) {
//		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.get(Routes.Users+"/"+userId);
				
		return  res;
	}

	public static Response createUser(User user) {


		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(user)
				.post(Routes.Users);
		
		return res;
		
	}

	public static Response deleteUser(String id) {
		Response res=RestAssured
				.when()
				.delete(Routes.Users+"/"+id);
				
		return  res;
	}

	public static Response getAllUsers() {
		
		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.get(Routes.Users);
				
		return  res;
	}

	public static Response getAllEmployeeData() {
		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.get(Routes.Employess);
				
		return  res;
	}

	public static Response createEmployee(Employee emp) {
		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(emp)
				.when()
				.post(Routes.Create_Employee);
		
		return res;
				
	}

	public static Response getCountryInfo(String country) {
		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("name", country)
				.queryParam("fullText", true)
				.when()
				.get("/{name}");
		
		return res;
	}

	public static Response getUserID(String userId) {
		Response res=RestAssured
				.given()
				.queryParam("userId", userId)
				.get(Routes.Posts);
		return res;
	}

	public static Response getCarInfo() {
		
		RestAssured.useRelaxedHTTPSValidation();
		
		Response res=RestAssured
				.get("/rentalcars");
		return res;
	}

	public static Response addCar(String carBody) {
		Response res=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(carBody)
				.when()
				.post("/rentalcars");
		
		return res;
	}
	
	

}
