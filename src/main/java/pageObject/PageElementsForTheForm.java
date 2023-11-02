package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageElementsForTheForm {
    // URL страницы с формой
    public static final String URL = "http://tl.af-ctf.ru/#inputForAuth";

    // Поиск элемента поля "Полное имя" по ID
    @FindBy(how = How.ID, using = "userName")
    public SelenideElement fullNameField;

    // Поиск элемента поля "Email" по ID
    @FindBy(how = How.ID, using = "email")
    public SelenideElement emailField;

    // Поиск элемента поля "Номер телефона" по ID
    @FindBy(how = How.ID, using = "phoneNumber")
    public SelenideElement phoneField;

    // Поиск элемента поля "Пароль" по ID
    @FindBy(how = How.ID, using = "password")
    public SelenideElement passwordField;

    // Поиск элемента поля "Подтверждение пароля" по ID
    @FindBy(how = How.ID, using = "passwordValidation")
    public SelenideElement repeatPasswordField;

    // Поиск элемента кнопки "Зарегистрироваться" по ID
    @FindBy(how = How.ID, using = "submitLogin")
    public SelenideElement getButton;

    @FindBy(how = How.ID, using = "loginModalAuth")
    public SelenideElement pop_upVerificationCode;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'signUpForm__errText') and text()='Неправильный формат почты']")
    public SelenideElement errorTextForEmail;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'signUpForm__errText') and text()='Сотовый номер должен содержать только цифры и начинаться с 7 или 8']")
    public SelenideElement errorTextForPhone;

    @FindBy(css = ".signUpInput.otp__errInput")
    public SelenideElement highlightingThePhoneField;

    // Метод для проверки текста элемента с ошибкой для email
    public void verifyEmailErrorText() {
        String expectedText = "Неправильный формат почты";
        errorTextForEmail.shouldHave(Condition.text(expectedText));
    }

    @Step("Проверка текста ошибки для неверного ввода номера телефона")
    // Метод для проверки текста элемента с ошибкой для номера телефона
    public void verifyPhoneErrorText() {
        String expectedText = "Сотовый номер должен содержать только цифры и начинаться с 7 или 8";
        errorTextForPhone.shouldHave(Condition.text(expectedText));
    }

    @Step("Проверка наличия активного элемента")
    // Метод для проверки наличия активного элемента
    public void verifyActiveElement() {
        pop_upVerificationCode.shouldBe(Condition.visible);
    }

    @Step("Ввод ФИО")
    // Метод для заполнения поля "Полное имя"
    public void fillFullNameField(String fullName) {
        fullNameField.setValue(fullName);
    }

    @Step("Ввод электронного адреса")
    // Метод для заполнения поля "Email"
    public void fillEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод телефона")
    // Метод для заполнения поля "Номер телефона"
    public void fillPhoneField(String phoneNumber) {
        phoneField.setValue(phoneNumber);
    }

    @Step("Ввод пароля")
    // Метод для заполнения поля "Пароль"
    public void fillPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("Подтверждение пароля")
    // Метод для заполнения поля "Подтверждение пароля"
    public void fillRepeatPasswordField(String repeatPassword) {
        repeatPasswordField.setValue(repeatPassword);
    }

    @Step("Жмем на кнопку Получить")
    // Метод для нажатия на кнопку "Зарегистрироваться"
    public void clickGetButton() {
        getButton.click();
        try {
            Thread.sleep(2000); // Пауза в 3 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Selenide.actions().sendKeys("\n").perform(); // Эмулировать нажатие клавиши "Enter"
    }

    @Step("Заполняем форму корректными данными")
    // Метод для заполнения всей формы регистрации клиента
    public void fillRegistrationForm(String fullName, String email, String phoneNumber, String password, String repeatPassword) {
        fillFullNameField(fullName);
        fillEmailField(email);
        fillPhoneField(phoneNumber);
        fillPasswordField(password);
        fillRepeatPasswordField(repeatPassword);
        clickGetButton();
    }

    @Step("Вводим некорректный номер телефона")
    // Метод для ввода некорректного номера телефона в поле "Номер телефона"
    public void fillIncorrectPhoneNumber(String incorrectPhoneNumber) {
        // Устанавливает указанный некорректный номер телефона в поле "Номер телефона"
        phoneField.setValue(incorrectPhoneNumber);
    }

    @Step("Форма с некорректным номером телефона")
    // Метод для заполнения всей формы регистрации клиента с некорректным номером телефона
    public void fillOutTheRegistrationFormWithAnIncorrectPhoneNumber(String fullName, String email, String incorrectPhoneNumber, String password, String repeatPassword) {
        // Заполняет все поля формы, включая поле "Номер телефона" с некорректным значением
        fillFullNameField(fullName);
        fillEmailField(email);
        fillIncorrectPhoneNumber(incorrectPhoneNumber);
        fillPasswordField(password);
        fillRepeatPasswordField(repeatPassword);
        clickGetButton();
    }

    @Step("Вводим некорректный электронный адрес")
    // Метод для ввода некорректного email
    public void fillIncorrectEmail(String incorrectEmail) {
        emailField.setValue(incorrectEmail);
    }

    @Step("Форма с некорректным электронным адресом")
    // Метод для заполнения всей формы регистрации клиента с некорректным email
    public void fillRegistrationFormWithIncorrectEmail(String fullName, String incorrectEmail, String phoneNumber, String password, String repeatPassword) {
        fillFullNameField(fullName);
        fillIncorrectEmail(incorrectEmail);
        fillPhoneField(phoneNumber);
        fillPasswordField(password);
        fillRepeatPasswordField(repeatPassword);
        clickGetButton();
    }

    @Step("Получаем цвет рамки,при ошибки ввода телефона")
    // Метод получения значения цвета рамки элемента, который выделен красным
    public String getBorderColor(SelenideElement highlightingThePhoneField) {
        return highlightingThePhoneField.getCssValue("border-color");
    }

    @Step("Проверяем выделенна ли рамка поля при ошибки")
    // Метод проверки, выделен ли элемент красным цветом
    public boolean isPhoneFieldHighlightedRed(String borderColor) {
        // Проверяем, соответствует ли цвет рамки красному (значение "rgb(255, 63, 63)")
        return borderColor.equals("rgb(255, 63, 63)");
    }


}

