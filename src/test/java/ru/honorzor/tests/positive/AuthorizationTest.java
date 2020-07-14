package ru.honorzor.tests.positive;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.honorzor.driver.SettingsForTest;
import ru.honorzor.pages.AuthorizationPage;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationTest extends SettingsForTest {
    private final static String EMAIL = "wibddmtssk@1secmail.com";
    private final static String PASSWORD = "PqxPZR";

    @Test
    public void authClient() {
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.authClient(EMAIL, PASSWORD);
        authorizationPage.logoutClient();
        boolean logoutButton = authorizationPage.isLogoutButton();
        Assert.assertTrue(logoutButton);
    }
}
