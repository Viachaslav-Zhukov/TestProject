import api.UserApiPattern;
import config.TestData;
import config.TestDataHelper;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class UserRegistrationTest {
    @Test
    @DisplayName("Успешная регистрация")
    public void testUserRegistration() {
        // Загрузка данных для регистрации пользователя из TestData
        TestData testData = TestDataHelper.loadTestData();

        // Создание объекта UserApiPattern
        UserApiPattern userApiPattern = new UserApiPattern();

        // Вызов метода для регистрации пользователя и получение ответа
        ValidatableResponse response = userApiPattern.registration(testData);

        // Проверка статус кода
        response.statusCode(302);
    }
}

