package ru.honorzor.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners({ScreenShooter.class})
public class SettingsForTest {
    private static final String URL = "https://test.uxcrowd.ru/";

    @BeforeClass
    public void openSession() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.reportsFolder = "allure-results";
        //open(URL);
    }

    @AfterClass
    public void closeSession() {
        SelenideLogger.removeListener("allure");
    }

    @AfterTest
    public void closeWeb() {
        closeWebDriver();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}
