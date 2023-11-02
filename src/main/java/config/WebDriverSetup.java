package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
    // Метод для настройки WebDriver с использованием WebDriverManager
    public static void setupWebDriver() {
        // Используем WebDriverManager для настройки ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Загрузка настроек
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    // Метод выполняющий после завершения теста
    public static void closeWebDriver() {
        // Очищаем cookies
        Selenide.clearBrowserCookies();
        // Завершаем работу с браузером, используя метод closeWebDriver из библиотеки Selenide
        com.codeborne.selenide.Selenide.closeWebDriver();
    }

}

