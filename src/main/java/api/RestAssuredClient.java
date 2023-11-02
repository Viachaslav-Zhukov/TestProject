package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RestAssuredClient {
    // Базовый URL, к которому будут отправляться запросы.
    public static final String BASE_URL = "http://tl.af-ctf.ru/";

    // Метод для получения базовой спецификации запроса.
    // Возвращает объект RequestSpecification, содержащий настройки для выполнения запроса.
    protected static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured()) // Добавление фильтра для интеграции с Allure-отчетами.
                .log(LogDetail.ALL) // Логирование всех деталей запроса и ответа.
                .setContentType(JSON) // Установка типа контента запроса как JSON.
                .setBaseUri(BASE_URL) // Установка базового URL для запросов.
                .build();
    }
}
