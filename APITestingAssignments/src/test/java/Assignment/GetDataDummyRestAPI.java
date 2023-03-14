package Assignment;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDataDummyRestAPI {
	
	@BeforeClass
	public void init() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	}
	
	@Test
	public void GetUserData_testcase01() {
		
		RequestSpecification request=RestAssured.given();
		Response res=request.when().get("/employees");
		
		String contentType=res.contentType();
		System.out.println("content type="+contentType);
		long responseTime=res.getTime();
		System.out.println("Response time="+responseTime);
		int statuscode=res.statusCode();
		System.out.println("status code="+statuscode);
		res.prettyPrint();
		res.then().statusCode(200);
		res.then().time(lessThan(5000L));
		res.then().contentType(ContentType.JSON);
		res.then().body("status",is("success"));
		
	}
	
	@Test()
	public void addUserData_testcase02() {
		Response res= RestAssured
		.given()
		.contentType(ContentType.JSON)
			.body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")
		.when()
		 .post("/create");
		res.then().statusCode(200);
		res.prettyPrint();
		res.then().body("status",is("success"));
   		
	}
	
	@Test()
	public void deleteUserData_testcase03() {
		Response res= RestAssured
		.given()
			.contentType(ContentType.JSON)
		.when()
		 .delete("/delete/7983");
		res.then().statusCode(200);
		res.prettyPrint();
		res.then().body("status",is("success"));
		
	}
	
	@Test()
	public void deleteUserData_testcase04() {
		Response res= RestAssured
		.given().contentType(ContentType.TEXT).pathParam("id", "0")
		.body("{\"id\":\"0\"}")
		.when()
		 .delete("/delete/{id}");
		res.then().statusCode(400);
		res.prettyPrint();
		res.then().body("status",is("error"));
		
	}
	
	@Test()
	public void GetUserData_testcase05() {

		Response res= RestAssured
				.given().contentType(ContentType.TEXT).pathParam("id", "2")
				.body("{\"id\":\"2\"}")
				.when().get("/employee/{id}");
				
				res.then().statusCode(200);
				res.prettyPrint();
				res.then().body("status",is("success"));
				res.then().body("data.employee_name", is ("Garrett Winters"));
				res.then().body("data.employee_salary", is (170750));
				res.then().body("data.employee_age", is (63));
				String contentType = res.contentType();
				System.out.println("contentType=" + contentType);
	}
}
