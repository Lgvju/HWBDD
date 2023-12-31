package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private final String balanceStart = "баланс: ";

    private final String balanceFinish = " р.";

    private final SelenideElement heading = $("[data-test-id='dashboard']");

    private final ElementsCollection cards = $$(By.className("list__item"));

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public int getCardBalance(DataHelper.CardInfo cardInfo) {
        var text = cards.findBy(text(cardInfo.getCardNumber().substring(15))).getText();
        return extractBalance(text);
    }
    public TransferPage selectCardTransfer(DataHelper.CardInfo cardInfo) {
        cards.findBy(text(cardInfo.getCardNumber().substring(15))).$("button").click();
        return new TransferPage();
    }

    //"data-test-id",cardInfo.getTestId()

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
