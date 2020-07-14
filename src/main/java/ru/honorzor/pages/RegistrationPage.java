package ru.honorzor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private static final String PHONENUMBER = "89999999999";


    private SelenideElement openWindowButton = $("[class=\"nl-btn nl-btn-white lk-btn header-button-lk\"]");
    private SelenideElement registrationButton = $("[ng-tr=\"WHE.WHE20\"]");
    private SelenideElement toBeClient = $("[ng-tr=\"WHE1.WHE12\"]");
    private SelenideElement fieldForName = $("[id=\"name\"]");
    private SelenideElement fieldPosition = $("[id=\"position\"]");
    private SelenideElement fieldCompany = $("[id=\"company\"]");
    private SelenideElement fieldEmail = $("[id=\"emails\"]");
    private SelenideElement fieldPhone = $("[id=\"phoneNumber\"]");
    private SelenideElement toBeClientButton = $("[class=\"lk-enter-btn ng-scope\"]");
    private SelenideElement textAfterSuccessRegistration = $("[class=\"header_modal_window text-center ng-binding\"]");

    @Story("Registration new client")
    public void registrationClient(String name, String position, String company, String email) {
        clickWindow();
        registrationButton();
        ToBeClientButton();
        fillFieldName(name);
        fillFieldPosition(position);
        fillFieldCompany(company);
        fillFieldEmail(email);
        fillFieldPhone();
        registrationClient();
    }


    @Step("get text after success registration client")
    public String getTextAfterRegistration() {
        return textAfterSuccessRegistration.shouldBe(visible).getText();
    }

    @Step("click button registration client")
    public void registrationClient() {
        toBeClientButton.click();
    }

    @Step("fill field phone client")
    public void fillFieldPhone() {
        fieldPhone.setValue(PHONENUMBER);
    }

    @Step("fill field email client")
    public void fillFieldEmail(String email) {
        fieldEmail.setValue(email);
    }

    @Step("fill field company client")
    public void fillFieldCompany(String company) {
        fieldCompany.setValue(company);
    }

    @Step("fill field position client")
    public void fillFieldPosition(String position) {
        fieldPosition.setValue(position);
    }

    @Step("fill field name client")
    public void fillFieldName(String name) {
        fieldForName.setValue(name);
    }

    @Step("click button to be client")
    public void ToBeClientButton() {
        toBeClient.shouldBe(visible).click();
    }

    @Step("click button registration")
    public void registrationButton() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("open window for registration or authorization client")
    public void clickWindow() {
        openWindowButton.shouldBe(visible).click();
    }
}
