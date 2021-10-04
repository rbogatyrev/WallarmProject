package com.wallarm.steps;

import com.wallarm.entities.User;

import com.wallarm.pages.LoginPage;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Step("Login Wallarm Dashboard")
    public void login(@NotNull User user) {
        loginPage.open();
        loginPage.assertPageIsLoaded();
        loginPage.setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButton();
    }
}
