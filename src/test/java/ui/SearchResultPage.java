package ui;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public WebElement getResults() {
        return $("div.serp-adv__found");
    }

    public Boolean resutsMoreThanSomeNumber (int number) {
        String textOfResults = getResults().getText();
        System.out.println(textOfResults);
        String textOfResultsDigit = textOfResults.split("\\s")[2];
        System.out.println(textOfResultsDigit);
        Long numberOfResultsDigit = Long.parseLong(textOfResults.split("\\s")[1]);
        Long numberOfResults = numberOfResultsDigit * getDigit(textOfResultsDigit);
        return numberOfResults > number;
    }

    private long getDigit(String textDigit) {
        if (textDigit.equals("млн")) {
            return 1000000;
        }
        else if (textDigit.equals("тыс.")) {
            return 1000;
        }
        else return 1;
    }
}