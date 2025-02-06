package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BeforeAll {

    @org.junit.jupiter.api.BeforeAll
    @Step("Подготовка тестового окружения")
    static void beforeAll(){
        System.setProperty("baseUrl", "https://oshisha.net/");
        System.setProperty("browser", "chrome");
        System.setProperty("browserResolution", "1920x1080");
        System.setProperty("webDriverHost", "selenoid.autotests.cloud");

        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserSize = System.getProperty("browserResolution");
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;

        Configuration.remote = "https://user1:1234@"+ System.getProperty("webDriverHost") +"/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

        open(System.getProperty("baseUrl"));
        //закрыть проверку 18+
        $("#trueModal div.age-access__buttons").$("a.age-access__button.age-access__yes").click();
        $("#\\32 Modal div.age-access__buttons").$("a.age-access__button.age-access__yes").click();
        //логин для доступа к табачке
        $(".box_with_basket_login").click();
        $("a.email-login").click();
        $("[name=EMAIL]").setValue("schicksalkreuzung@gmail.com");
        $("[name=PASSWORD]").setValue("11235813");
        $("[value=Войти]").click();
    }
}
