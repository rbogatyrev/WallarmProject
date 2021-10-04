package com.wallarm.steps;

import com.wallarm.pages.SupportPage;
import io.qameta.allure.Step;

public class SupportSteps {

    SupportPage supportPage = new SupportPage();

    @Step("Click send support ticket button")
    public void sendSupportTicket(){
        supportPage.clickSendRequestButton();
    }

    @Step("Click open documentation page button")
    public void clickDocumentationButton(){
        supportPage.clickDocumentationButton();
    }

}
