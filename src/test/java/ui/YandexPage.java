package ui;

import static com.codeborne.selenide.Selenide.$;

public class YandexPage {
    public void searchFor(String text) {
        $("input#text.input__control.input__input").val(text).pressEnter();
    }
}