import api.UserApiPattern;
import config.TestData;
import config.TestDataHelper;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class UserLoginTest {
    @Test
    @DisplayName("Корректный вход с главной страницы")
    public void testUserLogin() {
        // Загрузка данных для входа пользователя из TestData
        TestData testData = TestDataHelper.loadTestData();

        // Создание объекта UserApiPattern
        UserApiPattern userApiPattern = new UserApiPattern();

        // Вызов метода для входа пользователя и получение ответа
        ValidatableResponse response = userApiPattern.login(testData);

        // Проверка статус кода
        response.statusCode(302);
    }
}
