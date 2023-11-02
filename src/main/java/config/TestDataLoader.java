package config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import java.util.Properties;

/*Этот класс TestDataLoader загружает данные из файла test-data.properties и
предоставляет методы для получения значений различных полей из этих данных*/
public class TestDataLoader {
    // Объявление приватной статической переменной для хранения данных из файла
    private static Properties testData = null;

    // Статический блок инициализации, выполняется при первой загрузке класса
    static {
        try {
            // Создание объекта Path для указания пути к файлу с данными
            Path path = Paths.get("src/main/resources/test-data.properties");

            // Открываем файл с данными в виде потока данных
            try (InputStream inputStream = Files.newInputStream(path)) {
                // Создание объекта Properties для хранения данных
                testData = new Properties();

                // Загрузка данных из потока в объект Properties
                testData.load(inputStream);
            }
        } catch (IOException e) {
            // В случае ошибки ввода/вывода, выводим сообщение об ошибке
            e.printStackTrace();
        }
    }

    // Метод для получения значения "fullName" из данных
    public static String getFullName() {
        return testData.getProperty("fullName");
    }

    // Метод для получения значения "email" из данных
    public static String getEmail() {
        return testData.getProperty("email");
    }

    public static String getincorrectEmail() {
        return testData.getProperty("incorrectEmail");
    }

    // Метод для получения значения "phoneNumber" из данных
    public static String getPhoneNumber() {
        return testData.getProperty("phoneNumber");
    }

    public static String getIncorrectPhoneNumber() {
        return testData.getProperty("incorrectPhoneNumber");
    }

    // Метод для получения значения "password" из данных
    public static String getPassword() {
        return testData.getProperty("password");
    }

    // Метод для получения значения "repeatPassword" из данных
    public static String getRepeatPassword() {
        return testData.getProperty("repeatPassword");
    }

    // Методы для загрузки данных API из файла
    public static String getApiLogin() {
        return testData.getProperty("apiLogin");
    }

    public static String getApiPassword() {
        return testData.getProperty("apiPassword");
    }

    public static String getAuthCode() {
        return testData.getProperty("authCode");
    }
}
