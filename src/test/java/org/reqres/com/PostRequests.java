package org.reqres.com;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequests {
    @Test
    public void createUser() {
        //String req = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
        User user = new User();
        user.setName("Dilip Meghwal");
        user.setJob("Software Engineer");

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .log().all()
                .assertThat().body("name", equalTo("Dilip Meghwal"));
    }
}
