package ru.honorzor.driver;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class SettingsForTest {
    private static final String URL = "https://test.uxcrowd.ru/";

    @BeforeClass
    public void openSession() {
        open(URL);
        ScreenShooter.captureSuccessfulTests = true;
    }


    @AfterClass
    public void closeSession() {
        closeWebDriver();
    }
}
