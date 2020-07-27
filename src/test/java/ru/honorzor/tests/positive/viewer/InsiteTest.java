package ru.honorzor.tests.positive.viewer;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.AuthorizationPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.honorzor.helpers.LocatorHelper.byClass;
import static ru.honorzor.helpers.LocatorHelper.byTestId;

public class InsiteTest extends SettingsForTest {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final String EMAILFORFIRSTTEST = "catodog12@yopmail.com";
    private static final String PASSWORDFORFIRSTTEST = "dL1WlI";

    private static final String EMAILFORSECONDTEST = "agentofasgard32@yopmail.com";
    private static final String PASSWORDFORSECONDTEST = "0yngHh";

    private static final String EMAILFORTHIRDTEST = "gobananas@yopmail.com";
    private static final String PASSWORDFORTHIRDTEST = "SzIDto";

    private static final String URL = "https://preprod.uxcrowd.ru";

    @Test(priority = 1)
    @Description(value = "1.14.1 Отображение страницы Инсайтов без видео-фрагментов")
    public void viewInsiteWithOutVideoFragment() {
        step("Открыть главную страницу", () -> authorizationPage.openSession(URL));
        step("Открыть окно входа/регистрации", authorizationPage::openFormAuth);
        step("Ввести логин заранее известный", () -> authorizationPage.fillFieldEmail(EMAILFORFIRSTTEST));
        step("Ввести пароль заренее известный", () -> authorizationPage.fillPasswordField(PASSWORDFORFIRSTTEST));
        step("Нажать на кнопку", authorizationPage::pressEnterButton);

        step("Ожидать появление элемента", () -> $(byClass("block_exit_text text_settings")).shouldBe(visible));
        step("Ввести в поиск слово 'Литрес')", () -> $(byClass("sc-pRFjI kVKwZs MuiInputBase-input")).setValue("Литрес"));
        step("Нажать на слово 'Литрес'", () -> $(byClass("transcript-highlight transcript-highlight--active")).shouldBe(visible).click());

        step("Нажать на кнопку 'Перейти к инсайтам'", ()
                -> $x("//a[contains(@href,'insights')]")
                .shouldBe(visible).click());

        step("Ожидаем появления элементов", () -> $(byClass("MuiButtonBase-root MuiTableSortLabel-root sc-qapaw jspuZe"))
                .shouldBe(visible));

        step("Нажать кнопку 'Выйти'", () -> $(byClass("block_exit_text text_settings")).shouldBe(visible).click());
        step("Ожидаем появления элемента главной страницы", () -> $(byClass("nl-header-link")).shouldBe(visible));

    }

    @Test(priority = 2)
    @Description(value = "1.14.2 Переход к видео-фрагменту со страницы Инсайты")
    public void viewInsiteVideoFragment() {
        step("Открыть главную страницу", () -> authorizationPage.openSession(URL));
        step("Открыть окно входа/регистрации", authorizationPage::openFormAuth);
        step("Ввести логин заранее известный", () -> authorizationPage.fillFieldEmail(EMAILFORSECONDTEST));
        step("Ввести пароль заренее известный", () -> authorizationPage.fillPasswordField(PASSWORDFORSECONDTEST));
        step("Нажать на кнопку", authorizationPage::pressEnterButton);

        step("Нажимаем на тест с названием 'Тест свои моб'", ()
                -> $(byClass("MuiTableCell-root MuiTableCell-body sc-qQxXP ldFSrk"))
                .shouldBe(visible).click());

        step("Нажать на кнопку 'Перейти к инсайтам'", ()
                -> $x("//a[contains(@href,'insights')]")
                .shouldBe(visible).click());

        step("Ожидаем элемент отображения комментариев", () -> $(byClass("MuiBox-root jss2")).shouldBe(visible));
        step("Нажать кнопку 'Выйти'", () -> $(byClass("block_exit_text text_settings")).shouldBe(visible).click());
        step("Ожидаем появления элемента главной страницы", () -> $(byClass("nl-header-link")).shouldBe(visible));
    }

    @Test(priority = 3)
    @Description(value = "1.15.4 Создание черновика (прерывание создания теста на странице Проверка и запуск")
    public void createDraft() {
        step("Открыть главную страницу", () -> authorizationPage.openSession(URL));
        step("Открыть окно входа/регистрации", authorizationPage::openFormAuth);
        step("Ввести логин заранее известный", () -> authorizationPage.fillFieldEmail(EMAILFORTHIRDTEST));
        step("Ввести пароль заренее известный", () -> authorizationPage.fillPasswordField(PASSWORDFORTHIRDTEST));
        step("Нажать на кнопку", authorizationPage::pressEnterButton);

        step("Нажать на кнопку 'Создать новый тест'", () -> $(byClass("item_menu_logo new_test"))
                .shouldBe(visible).click());

        step("Ввести текст в поле 'Название теста'", () -> $(byTestId("Test name input")))
                .shouldBe(visible).setValue("Тест сайта (копирование)");

        step("Ввести в поле 'Адрес сайта', который тестируем", () -> $(byTestId("Address site input"))
                .shouldBe(visible).setValue("uxcrowd.ru"));

        step("Нажать кнопку 'К выбору аудитории'", () -> $(byTestId("Submit button")).click());

        step("Ввести в поле 'Название сегмента'", () -> $(byTestId("Segment name input 0"))
                .shouldBe(visible).setValue("Сегмент №1"));

        step("В группе Пол выбрать: Мужской", () -> $(byClass("sc-jWBwVP fxzKRy")).click());

        step("Нажать кнопку 'К заданиям'", () -> $(byTestId("Tasks button")).shouldBe(visible).click());

        step("Ввести голосовой ответ", () -> $(byTestId("Tasks task question"))
                .shouldBe(visible).setValue("Опишите свое первое впечатление от сайта."));

        step("Нажать кнопку 'Добавить'", () -> $(byTestId("Tasks submit task")).shouldBe(visible).click());


        step("Нажать кнопку 'Проверка и запуск'", () -> $(byTestId("Check button")).shouldBe(visible)).click();

        step("Прервать создание теста и нажать кнопку 'Профиль'", () -> $(byTestId("Profile client menu button"))
                .shouldBe(visible).click());

        step("Ожидаем элемент на странице 'Профиль'", () -> $(byClass("header_el_item"))
                .shouldBe(visible));

        step("Нажать кнопку 'Выйти'", () -> $(byClass("block_exit_text text_settings")).shouldBe(visible).click());
        step("Ожидаем появления элемента главной страницы", () -> $(byClass("nl-header-link")).shouldBe(visible));
    }
}
