package org.reqres.com;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequests {
    @Test
    public void getListOfUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .assertThat().body("page", equalTo(2));
    }

    @Test
    public void getSingleUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
    }
}
