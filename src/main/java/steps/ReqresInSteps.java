package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.requestModal.JobRequest;
import model.requestModal.RequestLogin;
import model.requestModal.RequestUserAdd;
import model.responseModal.*;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresInSteps {
    @Step

    public void requestIn() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Step
    public UserResponse requestSingleUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then().statusCode(200)
                .log()
                .all()
                .extract()
                .body()
                .as(UserResponse.class);

        return null;
    }

    @Step
    public void NotFoundUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }

    @Step
    public List<DataResponse> listResourse() {
        given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .log()
                .all();
        return null;
    }

    @Step
    public void singleResourse() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Step
    public void singleResourseNotFound() {
        given().when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(404);
    }

    @Step
    public JobResponse postCreate(JobRequest jober) {
        return given()

                .contentType(ContentType.JSON)
                .when()
                .body(jober)
                .post("https://reqres.in/api/users")
                .then().statusCode(201).log().all().extract().body().as(JobResponse.class);

    }

    @Step
    public JobResponse putUpdate(JobRequest lider) {
        return given()

                .contentType(ContentType.JSON)
                .when()
                .body(lider)
                .put("https://reqres.in/api/unknown/2")
                .then().statusCode(200).log().all().extract().body().as(JobResponse.class);
    }

    @Step
    public JobResponse  patchUpdate(JobRequest lider) {
        return given()

                .contentType(ContentType.JSON)
                .when()
                .body(lider)
                .patch("https://reqres.in/api/users/2")
                .then().statusCode(200).log().all().extract().body().as(JobResponse.class);

    }

    @Step
    public void deleteApi() {
        given()

                .contentType(ContentType.JSON)
                .when()
                .delete("https://reqres.in/api/users/2")
                .then().statusCode(204);
    }


    @Step
    public ResponseUserAdd RegisterCreate(RequestUserAdd userLogin) {
        return given()

                .contentType(ContentType.JSON)
                .when()
                .body(userLogin)
                .post("https://reqres.in/api/register")
                .then().statusCode(200)
                .log()
                .all()
                .extract()
                .body()
                .as(ResponseUserAdd.class);

    }

    @Step
    public void RegisterUNCreate() {

        ResponseUserAdd responseUserAdd = given()

                .contentType(ContentType.JSON)
                .when()
                .body(new RequestUserAdd("sydney@fife"))
                .post("https://reqres.in/api/register")
                .then().statusCode(400).log().all().extract().body().as(ResponseUserAdd.class);
        Assert.assertEquals("Missing password", responseUserAdd.error);
    }

    @Step
    public ResponseLogin loginUser(RequestLogin requestLogin) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestLogin)
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body()
                .as(ResponseLogin.class);
    }

    public void loginUnUser() {
        ResponseLogin responseLogin = given()

                .contentType(ContentType.JSON)
                .when()
                .body(new RequestLogin("peter@klaven"))
                .post("https://reqres.in/api/login")
                .then().statusCode(400).log().all().extract().body().as(ResponseLogin.class);
        Assert.assertEquals("Missing password", responseLogin.error);
    }
    @Step
    public void Delay() {
        given()
                .when()
                .get("https://reqres.in//api/users?delay=3")
                .then().statusCode(404)
                .log()
                .all();
    }

}
