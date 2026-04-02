package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviderss;
import io.restassured.response.Response;

public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviderss.class)
	public void testPostUser(String userID, String userName, String fName, String lName, String email,String pwd, String phNum) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPhone(phNum);
		userPayload.setPassword(pwd);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviderss.class)

	void deleteUserByName(String username) {
		Response response = UserEndPoints.deleteUser(username);

		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
