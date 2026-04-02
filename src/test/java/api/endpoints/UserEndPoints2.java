package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created to perform create, Read , Update and Delete requests the user API

public class UserEndPoints2 {

	static ResourceBundle getURLfromPropertiesFile() {
		ResourceBundle res = ResourceBundle.getBundle("routes");

		return res;
	}

	public static Response createUser(User payload) {

		String post_url = getURLfromPropertiesFile().getString("post_url");

		Response response = given()
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(payload)
							.when()
									.post(post_url);
		return response;
	}

	public static Response readUser(String username) {

		String get_url = getURLfromPropertiesFile().getString("get_url");

		Response response = given()
									.pathParam("username", username)
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
							.when()
									.get(get_url);
		return response;
	}

	public static Response updateUser(String username, User payload) {

		String update_url = getURLfromPropertiesFile().getString("update_url");

		Response response = given()
									.pathParam("username", username)
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(payload)
							.when()
									.put(update_url);
		return response;
	}

	public static Response deleteUser(String username) {

		String delete_url = getURLfromPropertiesFile().getString("delete_url");

		Response response = given()
									.pathParam("username", username)
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
							.when()
									.delete(delete_url);
		return response;
	}
}