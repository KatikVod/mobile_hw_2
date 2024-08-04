package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorMobileDriver;
import drivers.RealMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = null;

        if (System.getProperty("deviceHost", "browserstack").equals("real")) {
            Configuration.browser = RealMobileDriver.class.getName();
        } else if (System.getProperty("deviceHost", "browserstack").equals("emulation")) {
            Configuration.browser = EmulatorMobileDriver.class.getName();
        } else if (System.getProperty("deviceHost", "browserstack").equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        if (System.getProperty("deviceHost", "browserstack").equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}