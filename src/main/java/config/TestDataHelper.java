package config;

/*Этот класс TestDataHelper выполняет загрузку данных из TestDataLoader и устанавливает их в объект TestData,
который затем возвращается для использования в тестовом классе.
 */
public class TestDataHelper {
    // Определение метода, который будет загружать данные тестового набора
    public static TestData loadTestData() {
        // Создание объекта TestData, который будет содержать данные тестового набора
        TestData testData = new TestData();

        // Установка значения поля fullName объекта testData с использованием данных из TestDataLoader
        testData.setFullName(TestDataLoader.getFullName());

        // Установка значения поля email объекта testData с использованием данных из TestDataLoader
        testData.setEmail(TestDataLoader.getEmail());

        testData.setincorrectEmail(TestDataLoader.getincorrectEmail());

        // Установка значения поля phoneNumber объекта testData с использованием данных из TestDataLoader
        testData.setPhoneNumber(TestDataLoader.getPhoneNumber());

        testData.setIncorrectPhoneNumber(TestDataLoader.getIncorrectPhoneNumber());

        // Установка значения поля password объекта testData с использованием данных из TestDataLoader
        testData.setPassword(TestDataLoader.getPassword());

        // Установка значения поля repeatPassword объекта testData с использованием данных из TestDataLoader
        testData.setRepeatPassword(TestDataLoader.getRepeatPassword());

        // Загрузка данных API
        testData.setApiLogin(TestDataLoader.getApiLogin());
        testData.setApiPassword(TestDataLoader.getApiPassword());
        testData.setAuthCode(TestDataLoader.getAuthCode());

        // Возврат объекта testData с загруженными данными тестового набора
        return testData;
    }
}


