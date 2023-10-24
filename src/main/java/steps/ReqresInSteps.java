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
        given().baseUri("https://reqres.in/").when().get("api/users?page=2").then().log().all();
    }

    @Step
    public UserResponse requestSingleUser() {
        given().baseUri("https://reqres.in/").when().get("api/users/2").then().log().all().extract().body().as(UserResponse.class);

        return null;
    }

    @Step
    public void NotFoundUser() {
        given().baseUri("https://reqres.in/").when().get("api/users/23").then().statusCode(404);
    }

    @Step
    public List<DataResponse> listResourse() {
        given().baseUri("https://reqres.in/").when().get("api/unknown").then().log().all();
        return null;
    }

    @Step
    public void singleResourse() {
        given().baseUri("https://reqres.in/").when().get("api/unknown/2").then().log().all();
    }

    @Step
    public void singleResourseNotFound() {
        given().baseUri("https://reqres.in/").when().get("api/unknown/23").then().statusCode(404);
    }

    @Step
    public JobResponse postCreate(JobRequest jober) {
        return given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .body(jober)
                .post("api/users")
                .then().statusCode(201).log().all().extract().body().as(JobResponse.class);

    }

    @Step
    public JobResponse putCreate(JobRequest lider) {
        return given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .body(lider)
                .put("/api/unknown/2")
                .then().statusCode(200).log().all().extract().body().as(JobResponse.class);
    }

    @Step
    public JobResponse patchCreate(JobRequest lider) {
        return given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .body(lider)
                .patch("api/users/2")
                .then().statusCode(200).log().all().extract().body().as(JobResponse.class);

    }

    @Step
    public void deleteCreate() {
        given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .delete("api/users/2")
                .then().statusCode(204);
    }


    @Step
    public ResponseUserAdd RegisterCreate(RequestUserAdd userLogin) {
        return given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .body(userLogin)
                .post("api/register")
                .then().statusCode(200).log().all().extract().body().as(ResponseUserAdd.class);

    }

    @Step
    public void RegisterUNCreate() {

        ResponseUserAdd responseUserAdd = given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .body(new RequestUserAdd("sydney@fife"))
                .post("api/register")
                .then().statusCode(400).log().all().extract().body().as(ResponseUserAdd.class);
        Assert.assertEquals("Missing password", responseUserAdd.error);
    }

    @Step
    public ResponseLogin loginUser(RequestLogin requestLogin) {
        return given().baseUri("https://reqres.in/").contentType(ContentType.JSON).when().body(requestLogin)
                .post("api/login").then().statusCode(200).log().all().extract().body().as(ResponseLogin.class);
    }

    public void loginUnUser() {
        ResponseLogin responseLogin = given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .body(new RequestLogin("peter@klaven"))
                .post("api/login")
                .then().statusCode(400).log().all().extract().body().as(ResponseLogin.class);
        Assert.assertEquals("Missing password", responseLogin.error);
    }
    @Step
    public void Delay() {
        given().baseUri("https://reqres.in/").when().get("/api/users?delay=3").then().log().all();
    }

}
