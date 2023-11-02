import config.TestData;
import config.TestDataHelper;
import config.WebDriverSetup;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.PageElementsForTheForm;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;


/*Этот класс RegistrationFormTest содержит методы для настройки и завершения работы с WebDriver, а также тестовый метод для заполнения формы регистрации,
который использует данные из TestDataHelper и PageObject для взаимодействия с веб-страницей*/
public class RegistrationFormTest {
    // Это поле предназначено для хранения объекта, позволяющего взаимодействовать с элементами страницы формы.
    private PageElementsForTheForm pageElements;
    // Поле для хранения объекта TestData
    private TestData testData;

    // Метод, выполняющийся перед запуском каждого теста в классе
    @Before
    public void setup() {
        // Вызываем метод для настройки WebDriver из класса WebDriverSetup
        WebDriverSetup.setupWebDriver();
        // Открываем страницу с формой регистрации, используя URL из класса PageElementsForTheForm
        open(PageElementsForTheForm.URL);
        // Получаем данные из файла с использованием TestDataHelper и сохраняем их в объект TestData
        testData = TestDataHelper.loadTestData();
        // Создаем объект pageElements для работы с элементами страницы и заполняем форму регистрации
        pageElements = page(PageElementsForTheForm.class);
    }

    // Метод, выполняющийся после завершения каждого теста в классе
    @After
    public void tearDown() {
        // Вызываем метод для завершения работы с браузером из класса WebDriverSetup
        WebDriverSetup.closeWebDriver();
    }

    @Test
    @DisplayName("Заполнение фомы регистрации валидными данными")
    // Тест проверяет заполнение формы корректными данными и наличие активного элемента ввода кода проверки
    public void fillInTheFormWithTheCorrectData() {
        pageElements.fillRegistrationForm(
                testData.getFullName(),       // Заполняем поле "Полное имя" данными из объекта testData
                testData.getEmail(),          // Заполняем поле "Email" данными из объекта testData
                testData.getPhoneNumber(),    // Заполняем поле "Номер телефона" данными из объекта testData
                testData.getPassword(),       // Заполняем поле "Пароль" данными из объекта testData
                testData.getRepeatPassword() // Заполняем поле "Повторите пароль" данными из объекта testData
        );
        // Проверка наличия активного элемента после успешного заполнения формы
        pageElements.verifyActiveElement();
    }

    @Test
    @DisplayName("Заполнение фомы регистрации с некорректным телефоном")
    // Тест проверяет заполнение формы данными, включая некорректный номер телефона, текст ошибки,
    //подсветку поля красным цветом.
    public void fillOutTheFormWithAnIncorrectPhoneNumber() {
        pageElements.fillOutTheRegistrationFormWithAnIncorrectPhoneNumber(
                testData.getFullName(),            // Заполняем поле "Полное имя" данными из объекта testData
                testData.getEmail(),               // Заполняем поле "Email" данными из объекта testData
                testData.getIncorrectPhoneNumber(), // Заполняем поле "Номер телефона" данными из объекта testData (некорректные данные)
                testData.getPassword(),            // Заполняем поле "Пароль" данными из объекта testData
                testData.getRepeatPassword()      // Заполняем поле "Повторите пароль" данными из объекта testData
        );
        // Проверка текста ошибки в случае некорректного номера телефона
        pageElements.verifyPhoneErrorText();

        // Извлекаем цвет рамки элемента highlightingThePhoneField
        String borderColor = pageElements.getBorderColor(pageElements.highlightingThePhoneField);

        // Проверяем, подсвечен ли элемент красным цветом
        assertTrue("Поле телефона не подсвечивается красным цветом.", pageElements.isPhoneFieldHighlightedRed(borderColor));

    }

    @Test
    @DisplayName("Заполнение фомы регистрации с некорректным электронным адресом")
    // Тест проверяет заполнение формы данными, включая некорректный адрес электронной почты, и текст ошибки
    public void fillOutTheFormByEnteringAnIncorrectEmailAddress() {
        pageElements.fillRegistrationFormWithIncorrectEmail(
                testData.getFullName(),       // Заполняем поле "Полное имя" данными из объекта testData
                testData.getincorrectEmail(), // Заполняем поле "Email" данными из объекта testData (некорректные данные)
                testData.getPhoneNumber(),    // Заполняем поле "Номер телефона" данными из объекта testData
                testData.getPassword(),       // Заполняем поле "Пароль" данными из объекта testData
                testData.getRepeatPassword() // Заполняем поле "Повторите пароль" данными из объекта testData
        );
        // Проверка текста ошибки в случае некорректного адреса электронной почты
        pageElements.verifyEmailErrorText();

    }

}
