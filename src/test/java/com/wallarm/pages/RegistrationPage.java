package com.wallarm.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.wallarm.enums.Urls.WALLARM_SIGNUP_PAGE;

public class RegistrationPage extends BasePage{

    private static final String MAIN_ELEMENT = "[data-test-id='register.form']";
    private static final String NAME_INPUT = "input[name='realname']";
    private static final String EMAIL_INPUT = "input[name='email']";
    private static final String PASSWORD_INPUT = "input[name='password']";
    private static final String SIGN_IN_BUTTON = "[data-test-id='register.signin.link']";
    private static final String SIGN_UP_BUTTON = "button[type='submit']";

    private ActivationPage activationPage = new ActivationPage();
    private LoginPage loginPage = new LoginPage();

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_SIGNUP_PAGE.getValue();
    }

    @Step("Set user name")
    public RegistrationPage setName(String name){
        $(NAME_INPUT).setValue(name);
        return this;
    }

    @Step("Set user password")
    public RegistrationPage setPassword (String password){
        $(PASSWORD_INPUT).setValue(password);
        return this;
    }

    @Step("Set user email")
    public RegistrationPage setEmail (String email){
        $(EMAIL_INPUT).setValue(email);
        return this;
    }

    @Step("Click create account")
    public ActivationPage clickCreateAccountButton(){
        $(SIGN_UP_BUTTON).click();
        return activationPage;
    }

    public LoginPage clickSignInButton(){
        $(SIGN_IN_BUTTON).click();
        return loginPage;
    }


}
