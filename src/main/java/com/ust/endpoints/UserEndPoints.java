package com.ust.endpoints;


import com.ust.payloads.UserModel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response getUser(long id) {
		Response response= RestAssured.given()
				.headers(
						
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.getSingleuser)
				.pathParam("id", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		return response;
	}
	
	public static Response getListUser() {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.getList)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		return response;
	}
	
	public static Response postReq(UserModel payload) {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.postRequest)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post();
		return response;
	}
	
	public static Response putReq(long id, UserModel payload) {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.putRequest)
				.pathParam("id", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.put();
		return response;
	}
	
	public static Response patchReq(long id, UserModel payload) {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.patchRequest)
				.pathParam("id", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.patch();
		return response;		
	}
	
	public static Response delReq(long id) {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.deleteRequest)
				.pathParam("id", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.delete();
		return response;
	}
	
	public static Response filtReq(long id) {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.filterRequest)
				.queryParam("postId", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		return response;
	}
	
	public static Response nestReq() {
		Response response= RestAssured.given()
				.headers(
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseuri)
				.basePath(Routes.nestedRequest)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		return response;
	}
	
}
