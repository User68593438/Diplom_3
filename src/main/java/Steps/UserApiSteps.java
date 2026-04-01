package Steps;

import data.TestData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.UserLoginModel;
import model.UserModel;
import org.openqa.selenium.WebDriver;

import static data.TestData.*;
import static io.restassured.RestAssured.given;

public class UserSteps {
    WebDriver driver;

    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Создать пользователя POST /api/auth/register")
    public static Response createTestUser(UserModel userModel) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userModel)
                .when()
                .post(TestData.BASE_URI + TestData.CREATE_USER)
                .then()
                .extract().response();
    }

    @Step("Удалить пользователя DELETE /api/auth/user")
    public static void deleteUser(String accessToken) {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER)
                .then()
                .extract().response();

    }
}

//    @Step("Создание тестового пользователя через API")
//    protected void createTestUser() {
//        email = "test" + System.currentTimeMillis() + "@yandex.ru";
//        password = "validPass123";
//        name = "TestUser";
//
//        Response response = userApi.createUser(email, password, name);
//        accessToken = response.jsonPath().getString("accessToken");
//    }
//
//    @Step("Удаление тестового пользователя")
//    protected void deleteTestUser() {
//        if (accessToken != null && !accessToken.isEmpty()) {
//            userApi.deleteUser(accessToken);
//            accessToken = null;
//        }
//    }
//
//    @Step("Выполнение входа в систему")
//    protected void login() {
//        mainPage.open();
//        mainPage.clickLoginButton();
//        loginPage.login(email, password);
//        mainPage.waitForLoad();
//    }