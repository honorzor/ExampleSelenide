package ru.honorzor.tests.positive.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class UxcrowdApiTest {


    Response response = get("https://test.uxcrowd.ru/api/account");


    @Test
    public void getAcc (){
        when()
                .get("https://test.uxcrowd.ru/v2/api/account")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void passwordChange (){
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body("{\n" +
                        "  \"password_new\": \"string\",\n" +
                        "  \"password_one\": \"string\",\n" +
                        "  \"repeat_password_new\": \"daas\"\n" +
                        "}")
        .when()
                .post("https://test.uxcrowd.ru/v2/api/account/password/change")
        .then()
                .statusCode(201).log().all();
    }


    @Test
    public void registerAcc (){
        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body("{\n" +
                        "  \"company\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"name\": \"string\",\n" +
                        "  \"position\": \"string\",\n" +
                        "  \"role\": \"ROLE_ADMIN\",\n" +
                        "  \"site\": \"string\",\n" +
                        "  \"tariffType\": \"PROJECT\",\n" +
                        "  \"telNumber\": \"string\"\n" +
                        "}")
        .when()
                .post("https://test.uxcrowd.ru/v2/api/register")
        .then()
                .statusCode(201)
                .log().all();
    }

}
