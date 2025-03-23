package api.testclasses;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import endpointsUtil.Routes;
import endpointsUtil.UserEndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.UserModel;
import test.listener.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class TestPath {

	public UserModel payload;

	@BeforeClass
	public void setUp() {
		RestAssured.useRelaxedHTTPSValidation();
		payload = new UserModel(1, "foo", "bar", 1);
	}

	@Test(priority = 0)
	public void getSingleResourceRequestTest() {
		Response response = UserEndPoints.getUser(payload.getId());
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then()
		.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
		.body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
		.body("userId", equalTo(1));
		response.then().assertThat()
		.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.singleJsonPath)));
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 1)
	public void getListResourcesTest() {
		Response response = UserEndPoints.getListUser();
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then().assertThat()
				.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.listJsonPath)));
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void postResourcesRequest(String title, String body, String userId) {
		UserModel payload = new UserModel();
		payload.setTitle(title);
		payload.setBody(body);
		payload.setId(Integer.parseInt(userId));
		Response response = UserEndPoints.postReq(payload);
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then()
		.body("title", equalTo(title))
		.body("body", equalTo(body));
		response.then().assertThat()
		.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.singleJsonPath)));
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Test(priority = 3)
	public void putRequestTest() {
		Response response = UserEndPoints.putReq(payload.getId(), payload);
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then()
		.body("title", equalTo("foo"))
		.body("body", equalTo("bar"))
		.body("userId", equalTo(1));
		response.then().assertThat()
		.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.singleJsonPath)));
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void patchRequestTest() {
		UserModel payload3 = new UserModel(1, "foo", "Hi...Hellooo", 1);
		Response response = UserEndPoints.patchReq(payload3.getId(), payload3);
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then()
		.body("title", equalTo("foo"))
		.body("body", equalTo("Hi...Hellooo"))
		.body("userId", equalTo(1));
		response.then().assertThat()
		.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.singleJsonPath)));
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 5)
	public void deleteRequestTest() {
		Response response = UserEndPoints.delReq(payload.getId());
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 6)
	public void filterRequestTest() {
		Response response = UserEndPoints.filtReq(payload.getId());
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then().assertThat()
		.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.filterJsonPath)));
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 7)
	public void nestRequestTest() {
		Response response = UserEndPoints.nestReq();
		ExtentReportsListener.setResponse(response); 
		response.then().log().all();
		response.then().assertThat();
		response.then().assertThat()
		.body(matchesJsonSchema(new File(System.getProperty("user.dir") + Routes.filterJsonPath)));
		assertEquals(response.getStatusCode(), 200);
	}
}
