package api;

import config.TestData;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserApiPattern extends RestAssuredClient {

    // Путь к ресурсу для входа пользователя.
    private static final String LOGIN_PATH = "Login/";

    // Путь к ресурсу для регистрации пользователя.
    private static final String REGISTRATION_PATH = "signUp/";

    @Step("Регистрация пользователя")
    public ValidatableResponse registration(TestData testData) {
        return given()
                .spec(getBaseSpec())
                .when()
                .body("{\"userName\":\"" + testData.getFullName()
                        + "\", \"phone\":\""
                        + testData.getPhoneNumber()
                        + "\", \"passwordValidation\":\""
                        + testData.getPassword()
                        + "\", \"email\":\""
                        + testData.getEmail()
                        + "\", \"password\":\""
                        + testData.getRepeatPassword()
                        + "\", \"authCode\":\""
                        + testData.getAuthCode() + "\"}")
                .post(REGISTRATION_PATH)
                .then().log().all();
    }

    @Step("Вход пользователя")
    public ValidatableResponse login(TestData testData) {
        return given()
                .spec(getBaseSpec())
                .when()
                .body("{\"login\":\"" + testData.getApiLogin()
                        + "\", \"password\":\""
                        + testData.getApiPassword()
                        + "\", \"authCode\":\""
                        + testData.getAuthCode() + "\"}")
                .post(LOGIN_PATH)
                .then().log().all();
    }
}
