package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import service.UserSession;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BeforeAll {

    @org.junit.jupiter.api.BeforeAll
    @Step("Подготовка тестового окружения")
    static void beforeAll(){

        UserSession us = new UserSession();

        Configuration.baseUrl = System.getProperty("baseUrl", "https://oshisha.net");
        Configuration.browserSize = System.getProperty("browserResolution", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        //логин-пароль для учебого хоста
        //Configuration.remote = "https://user1:1234@"+ System.getProperty("webDriverHost", "selenoid.autotests.cloud") +"/wd/hub";
        Configuration.remote = System.getProperty("webDriverHost", "217.114.8.221:8080");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

        us.skipAgeWarnings();
        us.loginForm();


    }
}
