package com.wallarm.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.wallarm.enums.Urls.MAILINATOR_MAINPAGE;

public class MailPage extends BasePage{

    private static final String INBOX_INPUT = "input#addOverlay";
    private static final String GO_BUTTON = "button#go-to-public";

    @Override
    protected String getMainPageElement() {
        return INBOX_INPUT;
    }

    @Override
    protected String getPageUrl() {
        return MAILINATOR_MAINPAGE.getValue();
    }

    public MailPage enterInbox(String inboxValue){
        $(INBOX_INPUT).sendKeys(inboxValue);
        return this;
    }

    public MailPage clickGoButton(){
        $(INBOX_INPUT).click();
        return this;
    }



}
