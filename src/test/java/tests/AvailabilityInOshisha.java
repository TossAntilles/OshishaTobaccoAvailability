package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AvailabilityInOshisha extends BeforeAll {

    @Tag("jent20")
    @ParameterizedTest(name = "{0}.")
    @Feature("Проверка наличия табака")
    @Story("Jent Cigar 20")
    @DisplayName("Проверка наличия ")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/jentCigar20.csv")
    void tobaccoAvailabilityJ20(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("/catalog/product"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }

    @Tag("jent100")
    @ParameterizedTest(name = "{0}.")
    @Feature("Проверка наличия табака")
    @DisplayName("Проверка наличия ")
    @Story("Jent Cigar 100")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/jentCigar100.csv")
    void tobaccoAvailabilityJ100(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("/catalog/product"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }

    @Tag("sapphire100")
    @ParameterizedTest(name = "{0}.")
    @Feature("Проверка наличия табака")
    @DisplayName("Проверка наличия ")
    @Story("Sapphire Crown 100")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/sapphireCrown100.csv")
    void tobaccoAvailabilityS100(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("/catalog/product"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }

    @Tag("otherTobacco")
    @ParameterizedTest(name = "{0}.")
    @Feature("Проверка наличия табака")
    @DisplayName("Проверка наличия ")
    @Story("Другие табаки")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/other.csv")
    void tobaccoAvailabilityOther(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("/catalog/product"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }



}
