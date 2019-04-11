package ui;

import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class UiTest {

    @Test
    public void userCanSearch() {
        open("https://yandex.ru/");
        new YandexPage().searchFor("Открытие");
        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertTrue(searchResultPage.resutsMoreThanSomeNumber(10000));
    }
}