package ru.honorzor.tests.positive;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.AuthorizationPage;
import ru.honorzor.pages.ProfilePage;
import ru.honorzor.pages.RegistrationPage;
import ru.honorzor.tempemail.PasswordFromMessage;

import java.util.Random;

@Story("Create new test client from profile")
public class CreateNewOrderTest extends SettingsForTest {

    private final ProfilePage profilePage = new ProfilePage();
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final PasswordFromMessage page = new PasswordFromMessage();

    private static final String EXCEPTEDTEXTAFTERCREATENEWTEST = "Ура! Тест создан и отправлен пользователям.";
    private static final String TESTNAME = "example test";
    private static final String WEBSITE = "codewars.com";
    private static final String SEGMENTNAME = "Segment";
    private static final String ANSWER = "how r u";
    private static final String URL = "https://test.uxcrowd.ru/";

    private final int randomNumber = new Random().nextInt(1000);
    private final String login = "registartionnewclient" + randomNumber + "@1secmail.com";

    @BeforeClass
    public void authClient() {
        registrationPage.registrationClient(TESTNAME, SEGMENTNAME, ANSWER, login);

        String idMessage = page.checkMail(login);
        String passwordFromMessage = page.getPasswordFromMessage(login, idMessage);

        authorizationPage.authClient(login, passwordFromMessage);
    }

    @Epic(value = "Create new test form free client")
    @Test
    public void createNewTest() {
        profilePage.createTest(TESTNAME, WEBSITE, SEGMENTNAME, ANSWER);
        String textAfter = profilePage.getTextAfter();
        Assert.assertEquals(textAfter, EXCEPTEDTEXTAFTERCREATENEWTEST);
    }
}
