package common;

import data.model.CreateCrocodileRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredFunctions {

    public static Response get(String url) {
        return given().contentType(ContentType.JSON).get(url);
    }

    public static Response post(String url, Object requestBody) {
        return given().contentType(ContentType.JSON).body(requestBody).post(url).then().extract().response();
    }

    public static Response post(String accessToken, String url, Object requestBody) {
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(requestBody).post(url);
    }

    public static Response get(String accessToken, String url){
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .get(url);
    }

    public static Response put(String accessToken, CreateCrocodileRequest request, String url){
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(request)
                .put(url);
    }

    public static Response patch(String accessToken, CreateCrocodileRequest request, String url){
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(request)
                .patch(url);

    }

    public static Response delete(String accessToken, String url){
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .delete(url);
    }

    public static Response getAll(String accessToken, String url){
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .get(url);
    }
}
