package com.wallarm.steps;

import com.wallarm.entities.User;
import com.wallarm.pages.PartnersPage;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

public class PartnersSteps {

    private PartnersPage partnersPage = new PartnersPage();

    @Step("Fill and send Become partners request form")
    public void sendBecomePartnersForm(@NotNull User user){
        partnersPage.clickBecomePartnersButton()
                .setEmail(user.getEmail())
                .setCompany(user.getCompanyName())
                .setFirstName(user.getFirstName())
                .clickSendButton();
    }

    @Step("Assert that become partners request was sent")
    public void assertRequestIsSent(){
        partnersPage.checkRequestIsSent();
    }

}
