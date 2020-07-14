package ru.honorzor.tests.positive;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.RegistrationPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.page;


public class RegistrationTest extends SettingsForTest {
    private final int randomNumber = new Random().nextInt(1000);

    private final String name = "Ivan" + randomNumber;
    private final String position = "Junoir";
    private final String company = "Perfomance";
    private final String email = "testforregistration" + randomNumber + "@1secmail.com";
    private static final String EXCEPTEDTEXTAFTERREGISTRATION = "Спасибо за регистрацию на UXCrowd!";


    @Test
    public void registrationTest() {
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.registrationClient(name, position, company, email);
        String textAfterRegistration = registrationPage.getTextAfterRegistration();
        Assert.assertEquals(textAfterRegistration, EXCEPTEDTEXTAFTERREGISTRATION);
    }
}
