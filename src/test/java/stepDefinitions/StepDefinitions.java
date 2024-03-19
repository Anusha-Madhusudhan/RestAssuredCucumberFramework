/**
 * 
 */
package stepDefinitions;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import requestPayloads.Address;
import requestPayloads.Company;
import requestPayloads.Employee;
import requestPayloads.Geo;
import requestPayloads.RentalCar;
import requestPayloads.User;
import utills.RequestMethods;
import wiremock.WireMockServerImple;

import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

/**
 * 
 */
public class StepDefinitions {
	static Response res;
	File baseURI = new File(
			"C:\\Users\\anush\\TekArch-workspace\\RestApi_Cucumber_Framework\\src\\test\\resources\\baseURI.json");
	JsonPath jp = new JsonPath(baseURI);

	@Before("@DummyApi1")
	public void setUp1(Scenario scenario) {
		RestAssured.baseURI = jp.getString("users");
		System.out.println("****************Before Scenario method**************");
		System.out.println("Before  " + scenario.getName() + "-------");
		 System.out.format("Thread ID -  feature file.\n",
			        Thread.currentThread().getId(), scenario);
	}

	@After("@DummyApi1")
	public void tesrDown1(Scenario scenario) {
		System.out.println("****************After Scenario method**************");
		System.out.println("After  " + scenario.getName() + "-------");
	}

	@Before("@DummyApi2")
	public void setUp2(Scenario scenario) {
		RestAssured.baseURI = jp.getString("employees");
		System.out.println("****************Before Scenario method**************");
		System.out.println("Before  " + scenario.getName() + "-------");
		System.out.format("Thread ID -  feature file.\n",
		        Thread.currentThread().getId(), scenario);
	}

	@After("@DummyApi2")
	public void tesrDown2(Scenario scenario) {
		System.out.println("****************After Scenario method**************");
		System.out.println("After  " + scenario.getName() + "-------");
	}

	@Before("@API3")
	public void setUp3(Scenario scenario) {
		RestAssured.baseURI = jp.getString("countries");
		System.out.println("****************Before Scenario method**************");
		System.out.println("Before  " + scenario.getName() + "-------");
	}

	@After("@API3")
	public void tesrDown3(Scenario scenario) {
		System.out.println("****************After Scenario method**************");
		System.out.println("After  " + scenario.getName() + "-------");
	}
	
	@Before("@RentalCarAPI")
	public void startWireMock() {
		RestAssured.baseURI=jp.getString("rentalCars");
		System.out.println("Starting the wiremock server");
		WireMockServerImple.startServer();
	}
	
	@After("@RentalCarAPI")
	public void stopWireMock() {
		System.out.println("Stoping the wiremock server");
		WireMockServerImple.stopServer();
	}

	@When("users want to get information about user id {string}")
	public void users_want_to_get_information_about_user_id(String userId) {

		res = RequestMethods.getUserInfo(userId);

	}

	@Then("the requested data is returned with success status code")
	public void the_requested_data_is_returned_with_success_status_code() {

		res.then().log().body();
		res.then().assertThat().statusCode(200);

	}

	@When("I want to create a new user in the data base")
	public void i_want_to_create_a_new_user_in_the_data_base() {
		User user = new User();
		Address add = new Address();
		Company cmp = new Company();
		Geo geo = new Geo();
		/**
		 * { "id": 1, "name": "Leanne Graham", "username": "Bret", "email":
		 * "Sincere@april.biz", "address": { "street": "Kulas Light", "suite": "Apt.
		 * 556", "city": "Gwenborough", "zipcode": "92998-3874", "geo": { "lat":
		 * "-37.3159", "lng": "81.1496" } }, "phone": "1-770-736-8031 x56442",
		 * "website": "hildegard.org", "company": { "name": "Romaguera-Crona",
		 * "catchPhrase": "Multi-layered client-server neural-net", "bs": "harness
		 * real-time e-markets" } }
		 */
		user.setName("XYC");
		user.setUsername("aaa");
		user.setEmail("Sincere@april.biz");
		user.setPhone("1-770-736-8031 x56442");
		user.setWebsite("ccccc");
		add.setCity("Gwenborough");
		add.setStreet("Kulas Light");
		add.setSuite("Apt. 556");
		add.setZipcode("92998-3874");
		geo.setLat("-37.3159");
		geo.setLng("81.1496");
		add.setGeo(geo);
		cmp.setBs("harness real-time e-markets");
		cmp.setCatchPhrase("Multi-layered client-server neural-net");
		cmp.setName("Romaguera-Crona");
		user.setCompany(cmp);
		user.setAddress(add);

		res = RequestMethods.createUser(user);

	}

	@Then("the new user should get created in DB and I get success status code")
	public void the_new_user_should_get_created_in_db_and_i_get_success_status_code() {

		res.then().log().all();
		res.then().assertThat().statusCode(201);

	}

	@When("I want to delete a new user in the data base")
	public void i_want_to_delete_a_new_user_in_the_data_base() {
		res = RequestMethods.deleteUser("1");
	}

	@Then("the  user should get deleted from DB and I get success status code")
	public void the_user_should_get_deleted_from_db_and_i_get_success_status_code() {
		res.then().log().all();
		res.then().assertThat().statusCode(200);
	}

	@When("I want to retrive all the users from the DB")
	public void i_want_to_retrive_all_the_users_from_the_db() {
		res = RequestMethods.getAllUsers();
	}

	@Then("all the users data should returned with success status code")
	public void all_the_users_data_should_returned_with_success_status_code()
			throws JsonMappingException, JsonProcessingException {
//		res.then().log().body();
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body(matchesJsonSchema(new File(
				"C:\\Users\\anush\\TekArch-workspace\\RestApi_Cucumber_Framework\\src\\test\\resources\\JsonSchema\\users_schema.json")));

		System.out.println("-----------GET ALL USERS------------");

		JsonNode jn = new ObjectMapper().readTree(res.asString());

		System.out.println(jn.getNodeType());
		System.out.println(jn.size());

		List<responsePayloads.User> userList = res.jsonPath().getList("", responsePayloads.User.class);

		for (responsePayloads.User u : userList) {
			System.out.println(u.getName());
		}
		System.out.println("-----ADDRESS-----");
		List<responsePayloads.Address> addList = res.jsonPath().getList("address", responsePayloads.Address.class);
		for (responsePayloads.Address add : addList) {
			System.out.println(add.getCity());
		}

		System.out.println("-----Company-----");
		List<responsePayloads.Company> cmpList = res.jsonPath().getList("company", responsePayloads.Company.class);
		for (responsePayloads.Company cmp : cmpList) {
			System.out.println(cmp.getName());
		}

//		res.then().assertThat().body(res, )
	}

	@When("I want to retrive all the information about the employees using get http method and {string}")
	public void i_want_to_retrive_all_the_information_about_the_employees_using_get_http_method_and(String string) {
		res = RequestMethods.getAllEmployeeData();

	}

	@Then("I should get the data along with success status code")
	public void i_should_get_the_data_along_with_success_status_code()
			throws JsonMappingException, JsonProcessingException {
		res.then().assertThat().statusCode(200);
		res.then().log().all();

		JsonNode jn = new ObjectMapper().readTree(res.asString());
		System.out.println(jn.get("status"));

		List<responsePayloads.Employee> empList = res.jsonPath().getList("data", responsePayloads.Employee.class);
		System.out.println(empList.size());
		for (responsePayloads.Employee emp : empList) {
			System.out.println(emp.getEmployee_name() + "    " + emp.getEmployee_salary());
		}
	}

	@When("I want to create a new employee data in the database")
	public void i_want_to_create_a_new_employee_data_in_the_database() {
		Employee emp = new Employee();
		emp.setEmployee_name("Aaaaaa");
		emp.setEmployee_salary(200000);
		emp.setEmployee_age(45);
		emp.setProfile_image("");
		res = RequestMethods.createEmployee(emp);
	}

	@Then("new employee data should be created in the database with success status code")
	public void new_employee_data_should_be_created_in_the_database_with_success_status_code() {
//		{
//		    "status": "success",
//		    "data": {
//		        "employee_name": "aaaa",
//		        "employee_salary": 100000,
//		        "employee_age": 25,
//		        "profile_image": null,
//		        "id": 2381
//		    },
//		    "message": "Successfully! Record has been added."
//		}
		res.then().log().all();
		res.then().assertThat().statusCode(200).assertThat().body("status", equalTo("success")).assertThat()
				.body("message", equalTo("Successfully! Record has been added."));

		int id = res.jsonPath().getInt("data.id");
		System.out.println(id);

		responsePayloads.Employee emp = res.jsonPath().getObject("data", responsePayloads.Employee.class);

		System.out.println(emp.getEmployee_name() + "  " + emp.getEmployee_age());

	}

	@When("I enter the full name {string} of the country and hit the get https request")
	public void i_enter_the_full_name_of_the_country_and_hit_the_get_https_request(String country) {
		res=RequestMethods.getCountryInfo(country);
	}

	@Then("I should get the information about the country")
	public void i_should_get_the_information_about_the_country() throws JsonMappingException, JsonProcessingException {
//		res.then().log().all();
		System.out.println("Below are the info of the country  "+res.jsonPath().getString("[0].name.common"));
		
		System.out.println("Capital :"+res.jsonPath().getString("[0].capital[0]"));
		System.out.println("Status :"+res.jsonPath().getString("[0].status"));
		System.out.println("Languages :"+res.jsonPath().getString("[0].languages"));
		System.out.println("Papulation :"+res.jsonPath().getString("[0].population"));
		System.out.println("Denonyms :"+res.jsonPath().getString("[0].demonyms.eng.f"));
		
		JsonNode jn=new ObjectMapper().readTree(res.asString());
		
		
		System.out.println(jn.getNodeType());  // ARRAY
		
		List<Object> list=res.jsonPath().getList("");
		
		System.out.println(list.size());
		
		File schemaFile=new File("C:\\Users\\anush\\TekArch-workspace\\RestApi_Cucumber_Framework\\src\\test\\resources\\JsonSchema\\county_schema.json");
		
		res.then().assertThat().body(matchesJsonSchema(schemaFile));
		
	}
	
	@When("I hit the URI for retriving the information about the UserId {string} using GET request")
	public void i_hit_the_uri_for_retriving_the_information_about_the_user_id_using_get_request(String userId) {
	    
		res=RequestMethods.getUserID(userId);
	}

	@Then("I should get all the information about the user along with the success code in the response")
	public void i_should_get_all_the_information_about_the_user_along_with_the_success_code_in_the_response() {
	
//		res.then().log().body();
		
		List<Object> list=res.jsonPath().getList("");
		
		for(int i=0;i<list.size();i++) {
		res.then().assertThat().body("["+i+"].userId",equalTo(7) );
		
		}
	}
	
	
	
	@When("I hit the api to fetch the rental car information using get http request method")
	public void i_hit_the_api_to_fetch_the_rental_car_information_using_get_http_request_method() {
		
		res=RequestMethods.getCarInfo();
		
	}

	@Then("I shoul get the response with required information along with success status code")
	public void i_shoul_get_the_response_with_required_information_along_with_success_status_code() {
		
//		Question 1: Print all the blue Teslas received in the web service response. Also print the notes
//		res.then().log().all();
		List<Object> carList=res.jsonPath().getList("Car");
		
		for(int i=0;i<carList.size();i++) {
			if(res.jsonPath().getString("Car["+i+"].metadata.Color").equalsIgnoreCase("blue")) {
				System.out.println("Notes:: "+res.jsonPath().getString("Car["+i+"].metadata.Notes"));
			}
		}
		
//		Question 2: Return all cars which have the lowest per day rental cost for both cases:
//			a. Price only
//			b. Price after discounts
		int lowestPrice=res.jsonPath().getInt("Car[0].perdayrent.Price");
		
		for(int i=1;i<carList.size();i++) {
			if(res.jsonPath().getInt("Car["+i+"].perdayrent.Price")<lowestPrice) {
				lowestPrice=res.jsonPath().getInt("Car["+i+"].perdayrent.Price");
			}
		}
			
			for(int y=0;y<carList.size();y++) {
				if(res.jsonPath().getInt("Car["+y+"].perdayrent.Price")==lowestPrice) {
					System.out.println("CAR:: "+res.jsonPath().getString("Car["+y+"].make"));
				}
			
		}
			
			
//			 Question 3: Find the highest revenue generating car. year over year maintenance cost
//			+ depreciation is the total expense per car for the full year for the rental car company.
// 			The objective is to find those cars that produced the highest profit in the last year
		
	}
	
	@When("I hit the api to add new rental car information using post http request method")
	public void i_hit_the_api_to_add_new_rental_car_information_using_post_http_request_method() {
//		RentalCar car=new RentalCar();
		
		File carJson=new File("C:\\Users\\anush\\TekArch-workspace\\RestApi_Cucumber_Framework\\src\\test\\resources\\car.json");
		JsonPath jp=new JsonPath(carJson);
		
		
	   res=RequestMethods.addCar(jp.toString());
	   
	}

	@Then("I should be able to add new car info to DB  along with success status code")
	public void i_should_be_able_to_add_new_car_info_to_db_along_with_success_status_code() {
		res.then().log().all();
		
	}
}
