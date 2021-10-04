package com.wallarm.steps;

import com.wallarm.entities.User;
import com.wallarm.pages.RegistrationPage;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static java.lang.String.format;

public class RegistrationSteps {

    private RegistrationPage registrationPage = new RegistrationPage();

    @Step("Register a new Wallarm user")
    public void registerNewUserWithWait(@NotNull User user) {
        registrationPage.setName(format("%s %s", user.getFirstName(), user.getLastName()))
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickCreateAccountButton()
                .assertPageIsLoaded();
    }

}
