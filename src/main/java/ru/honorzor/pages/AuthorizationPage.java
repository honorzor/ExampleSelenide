package ru.honorzor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    private SelenideElement openWindowAuth = $x("//*[@id=\"header-lk-button\"]"); // Кнопка открытия окна "Вход/Регистрация".

    private SelenideElement fieldEmail = $x("//*[@id=\"login\"]"); // Поле для ввода почты клиента.

    private SelenideElement fieldPassword = $x("//*[@id=\"form_auth\"]/input[2]"); // Поле для ввода пароля клиента.

    private SelenideElement enterButton = $x("//*[@id=\"form_auth\"]/button"); // Кнопка "Войти" в профиль клиента.

    private SelenideElement logoutButton = $x("//*[@id=\"logout\"]"); // Кнопка "Выйти" в профиль клиента.


    public void authClient(String email, String password) {
        openFormAuth();
        fillFieldEmail(email);
        fillPasswordField(password);
        pressEnterButton();
    }

    @Step(value = "check button isDisplayed")
    public boolean isLogoutButton() {
        return logoutButton.isDisplayed();
    }

    @Step(value = "click enter button")
    public void pressEnterButton() {
        enterButton.shouldBe(visible).pressEnter();
    }

    @Step(value = "fill password {0}")
    public void fillPasswordField(String password) {
        fieldPassword.setValue(password);
    }

    @Step(value = "fill email {0}")
    public void fillFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    @Step(value = "click button logout")
    public void logoutClient() {
        logoutButton.shouldBe(visible).click();
    }

    @Step(value = "open window for registration or login")
    public void openFormAuth() {
        openWindowAuth.shouldBe(visible).click();
    }

}
