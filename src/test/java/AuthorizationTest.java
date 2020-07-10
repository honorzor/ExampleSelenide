import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends SettingsForTest {
    /**
     * Данные ранее зарегистрированного клиента
     */
    private final static String EMAIL = "wibddmtssk@1secmail.com";
    private final static String PASSWORD = "PqxPZR";

    @Test
    public void authClient() {
        authorizationPage.authClient(EMAIL, PASSWORD);
        authorizationPage.logoutClient();
        boolean logoutButton = authorizationPage.isLogoutButton();
        Assert.assertTrue(logoutButton);
    }
}
