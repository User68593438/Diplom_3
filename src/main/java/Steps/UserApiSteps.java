package Steps;

import data.TestData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.UserModel;
import static data.TestData.*;
import static io.restassured.RestAssured.given;

public class UserApiSteps {

    @Step("Создать пользователя POST /api/auth/register")
    public static Response createUser(UserModel user) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URI + CREATE_USER)
                .then()
                .extract().response();
    }

    @Step("Удалить пользователя DELETE /api/auth/user")
    public static Response deleteUser(String token) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete(TestData.BASE_URI + TestData.DELETE_USER)
                .then()
                .extract().response();
    }
}
