package config;

/*Этот класс TestData определяет поля для хранения данных тестового набора и предоставляет геттеры и сеттеры для этих полей,
что позволяет получать и устанавливать значения полей объекта TestData*/
public class TestData {
    // Объявление приватных полей, которые будут содержать данные тестового набора
    private String fullName;         // Полное имя
    private String email;            // Адрес электронной почты
    private String phoneNumber;      // Номер телефона
    private String password;         // Пароль
    private String repeatPassword;   // Повтор пароля
    private String incorrectPhoneNumber;

    private String incorrectEmail;

    private String apiLogin;    // Логин для API
    private String apiPassword; // Пароль для API
    private String authCode;    // Код авторизации для API

    public String getApiLogin() {
        return apiLogin;
    }

    public void setApiLogin(String apiLogin) {
        this.apiLogin = apiLogin;
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    // Геттер для некорректного Email
    public String getincorrectEmail() {
        return incorrectEmail;
    }

    // Сеттер для некорректного Email
    public void setincorrectEmail(String incorrectEmail) {
        this.incorrectEmail = incorrectEmail;
    }

    // Геттер для некорректного номера телефона
    public String getIncorrectPhoneNumber() {
        return incorrectPhoneNumber;
    }

    // Сеттер для некорректного номера телефона
    public void setIncorrectPhoneNumber(String incorrectPhoneNumber) {
        this.incorrectPhoneNumber = incorrectPhoneNumber;
    }

    // Геттер для поля fullName, который возвращает значение этого поля
    public String getFullName() {
        return fullName;
    }

    // Сеттер для поля fullName, который устанавливает значение этого поля
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Геттер для поля email, который возвращает значение этого поля
    public String getEmail() {
        return email;
    }

    // Сеттер для поля email, который устанавливает значение этого поля
    public void setEmail(String email) {
        this.email = email;
    }

    // Геттер для поля phoneNumber, который возвращает значение этого поля
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Сеттер для поля phoneNumber, который устанавливает значение этого поля
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Геттер для поля password, который возвращает значение этого поля
    public String getPassword() {
        return password;
    }

    // Сеттер для поля password, который устанавливает значение этого поля
    public void setPassword(String password) {
        this.password = password;
    }

    // Геттер для поля repeatPassword, который возвращает значение этого поля
    public String getRepeatPassword() {
        return repeatPassword;
    }

    // Сеттер для поля repeatPassword, который устанавливает значение этого поля
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}


