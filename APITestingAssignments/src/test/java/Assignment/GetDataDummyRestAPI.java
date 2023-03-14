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
			//.body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")
		.when()
		 .delete("/delete/7983");
		res.then().statusCode(200);
		res.prettyPrint();
		res.then().body("status",is("success"));
		
	}
	
	@Test()
	public void GetUserData_testcase05() {

		RequestSpecification request=RestAssured.given();
		Response res=request.when().get("/employees");
		
		//res.then()
		//.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getDataSchema.json"));
		PojoData01[] id = res.as(PojoData01[].class);
		System.out.println("The records of id2=" +id[2].getEmployeeName());
		System.out.println("The records of id2=" +id[2].getEmployeeAge());
		System.out.println("The records of id2=" +id[2].getEmployeeSalary());
		/*String contentType=res.contentType();
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
		*/
		
	}
}
