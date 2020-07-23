package ru.honorzor.tests.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.RegistrationPage;

import java.util.Random;


@Story("Registration new client")
public class RegistrationTest extends SettingsForTest {
    private final RegistrationPage registrationPage = new RegistrationPage();

    private final int randomNumber = new Random().nextInt(1000);

    private final String name = "Ivan" + randomNumber;
    private final String position = "Junoir";
    private final String company = "Perfomance";
    private final String email = "testfor" + randomNumber + "@1secmail.com";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";

    @Description(value = "Registration with correct credentials")
    @Test(priority = 1)
    public void registrationTest() {
        registrationPage.registrationClient(name, position, company, email);
        String textAfterRegistration = registrationPage.getTextAfterRegistration();
        Assert.assertEquals(textAfterRegistration, EXCEPTEDTEXTAFTERREGISTRATION);
    }

    @Description(value = "Registration with incorrect credentials")
    @Test(priority = 2)
    public void registrationClient() {
        registrationPage.registrationClient(name, position, company, "testforregistration248@1secmail.com");
        String textAfterRegistration = registrationPage.getTextAfterRegistration();
        Assert.assertEquals(textAfterRegistration, EXCEPTEDTEXTAFTERREGISTRATION);
    }
}
