package ru.honorzor.tests.positive;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.AuthorizationPage;



@Story(value = "Test authorization client")
public class AuthorizationTest extends SettingsForTest {
    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    private final static String EMAIL = "wibddmtssk@1secmail.com";
    private final static String PASSWORDCORRECT = "PqxPZR";
    private final static String PASSWORDINCORRECT = "QQQQ";

    @Description(value = "Test with correct credentials")
    @Test
    public void authClient() {
        authorizationPage.authClient(EMAIL, PASSWORDCORRECT);
        authorizationPage.logoutClient();
        boolean logoutButton = authorizationPage.isLogoutButton();
        Assert.assertTrue(logoutButton);
    }


    @Description(value = "Test with incorrect credentials")
    @Test
    public void authClientWithIncorrect() {
        authorizationPage.openFormAuth();
        authorizationPage.fillFieldEmail(EMAIL);
        authorizationPage.fillPasswordField(PASSWORDINCORRECT);
        authorizationPage.pressEnterButton();
        Assert.assertTrue(authorizationPage.isLogoutButton());
    }
}
