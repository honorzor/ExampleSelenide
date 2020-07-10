import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class SettingsForTest {
    private static final String URL = "https://test.uxcrowd.ru/";
    public AuthorizationPage authorizationPage;

    @BeforeClass
    public void openSession() {
        open(URL);
        authorizationPage = new AuthorizationPage();
    }


    @AfterClass
    public void closeSession() {
        closeWebDriver();
    }
}
