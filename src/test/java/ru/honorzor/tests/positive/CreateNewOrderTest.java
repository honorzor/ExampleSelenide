package ru.honorzor.tests.positive;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.AuthorizationPage;
import ru.honorzor.pages.ProfilePage;
import ru.honorzor.pages.RegistrationPage;
import ru.honorzor.tempemail.PasswordFromMessage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.page;

public class CreateNewOrderTest extends SettingsForTest {

    private static final String EXCEPTEDTEXTAFTERCREATENEWTEST = "Ура! Тест создан и отправлен пользователям.";
    private static final String TESTNAME = "example test";
    private static final String WEBSITE = "codewars.com";
    private static final String SEGMENTNAME = "Segment";
    private static final String ANSWER = "how r u";

    private final int randomNumber = new Random().nextInt(1000);
    private final String login = "registartionnewclient" + randomNumber + "@1secmail.com";

    @BeforeClass
    public void authClient() {
        RegistrationPage regPage = page(RegistrationPage.class);
        regPage.registrationClient(TESTNAME, SEGMENTNAME, ANSWER, login);

        PasswordFromMessage page = page(PasswordFromMessage.class);
        String idMessage = page.checkMail(login);
        String passwordFromMessage = page.getPasswordFromMessage(login, idMessage);

        AuthorizationPage authPage = page(AuthorizationPage.class);
        authPage.authClient(login, passwordFromMessage);
    }

    @Test
    public void createNewTest() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.createTest(TESTNAME, WEBSITE, SEGMENTNAME, ANSWER);
        String textAfter = profilePage.getTextAfter();
        Assert.assertEquals(textAfter, EXCEPTEDTEXTAFTERCREATENEWTEST);
    }
}
