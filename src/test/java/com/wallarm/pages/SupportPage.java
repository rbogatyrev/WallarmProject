package com.wallarm.pages;

import com.wallarm.enums.Urls;

import static com.codeborne.selenide.Selenide.$;

public class SupportPage extends BasePage {

    private static final String MAIN_ELEMENT = "h1[class*='hero-title-support']";
    private static final String SEND_SUPPORT_REQUEST = "div.buttons-wrapper-2 a[href*='support']";
    private static final String DOCUMENTATION_BUTTON = "a[class*='nav-bar-button-documentation']";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return Urls.WALLARM_SUPPORT_PAGE.getValue();
    }

    public void clickSendRequestButton(){
        $(SEND_SUPPORT_REQUEST).click();
    }

    public void clickDocumentationButton(){
        $(DOCUMENTATION_BUTTON).click();
    }
}
