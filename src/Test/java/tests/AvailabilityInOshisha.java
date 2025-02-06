package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AvailabilityInOshisha extends BeforeAll {

    @ParameterizedTest(name = "Наличие {0}. ")
    @Feature("Проверка наличия табака")
    @Story("Jent Cigar 20")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/jentCigar20.csv")
    void tobaccoAvailabilityJ20(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("//catalog/product/"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }

    @ParameterizedTest(name = "Наличие {0}. ")
    @Feature("Проверка наличия табака")
    @Story("Jent Cigar 100")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/jentCigar100.csv")
    void tobaccoAvailabilityJ100(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("//catalog/product/"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }

    @Disabled
    @ParameterizedTest(name = "Наличие {0}. ")
    @Feature("Проверка наличия табака")
    @Story("Sapphire Crown 100")
    @Owner("Toss Antilles")
    @CsvFileSource(resources = "/jentCigar20.csv")
    void tobaccoAvailability(String tobaccoName, String link){
        //открыть страницу табака
        step("Открываем страницу табака " + tobaccoName, () -> {
            open("//catalog/product/"+link);
        });

        step("Табак есть в наличии", () -> {
            $(".add2basket").shouldBe(visible);
        });

    }




}
