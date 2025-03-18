package service;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UserSession {


    public void skipAgeWarnings(){
        open("/local/templates/Oshisha/images/favicon.ico");
        //age access
        localStorage().setItem("age_access", "1");
        sessionStorage().setItem("age_access", "1");
    }

    public void loginForm() {
        //session cookie
        open(System.getProperty("baseUrl"));
        //логин через форму
        $(".box_with_basket_login").click();
        $("a.email-login").click();
        $("[name=EMAIL]").setValue("schicksalkreuzung@gmail.com");
        $("[name=PASSWORD]").setValue("11235813");
        $("[value=Войти]").click();
    }

    public void loginCookie() {
        //session cookie
        Cookie cookie = new Cookie("PHPSESSID", "73093a3cdfee45fc567f5da4622cd5a5");
        getWebDriver().manage().deleteCookieNamed("PHPSESSID");
        getWebDriver().manage().addCookie(cookie);
    }
}
