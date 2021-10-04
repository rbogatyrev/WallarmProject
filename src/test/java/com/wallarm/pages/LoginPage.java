package com.wallarm.pages;

import com.wallarm.enums.Urls;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final String MAIN_ELEMENT = "[data-test-id='sign-in.login.forgot-password']";
    private static final String EMAIL_INPUT = "input[name='username']";
    private static final String PASSWORD_INPUT = "input[name='password']";
    private static final String LOGIN_BUTTON = "button[type='submit']";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return Urls.WALLARM_LOGIN_PAGE.getValue();
    }

    public LoginPage setEmail(String email) {
        $(EMAIL_INPUT).setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(PASSWORD_INPUT).setValue(password);
        return this;
    }

    public void clickLoginButton() {
        $(LOGIN_BUTTON).click();
    }
}
