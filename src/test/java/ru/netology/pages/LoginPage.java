package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.DataHelper;

public class LoginPage {

    @FindBy(css = "[data-test-id='login'] input")
    private SelenideElement loginField;

    @FindBy(css = "[data-test-id='password'] input")
    private SelenideElement passwordField;

    @FindBy(css = "[data-test-id='action-login']")
    private SelenideElement loginButton;

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue((info.getPassword()));
        loginButton.click();
        return new VerificationPage();
    }
}