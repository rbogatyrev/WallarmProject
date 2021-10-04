package com.wallarm.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.wallarm.utils.SimpleWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class InboxPage extends BasePage{

    private static final String MAIN_ELEMENT = "#inbox_pane";
    private static final String REFRESH_BUTTON = "#inbox_pane button[class='primary-btn']";
    private static final String EMAIL_SUBJECT = "//table[@class='table-striped jambo_table'] //tr //td[contains(text(), '%s')]";
    private static final String MESSAGE_FRAME = "//iframe[@id='messagecontframe']";
    private static final String EMAIL_CONFIRM_BUTTON = "//a[contains(@href,'activate')]";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return null;
    }

    public InboxPage waitForMessageWithSubjectReceived(String emailSubject){
        int attempts = 0;
        do {
            SimpleWait.waitSec(5);
            $x(REFRESH_BUTTON).click();
            attempts++;
            $x(format(EMAIL_SUBJECT, emailSubject)).click();
        }
        while (!($x(format(EMAIL_SUBJECT, emailSubject)).is(visible)) && attempts < 10);
        return this;
    }

    public void clickOnEmailConfirmLink(){
        Selenide.switchTo().frame($x(MESSAGE_FRAME));
        WebDriverRunner.getWebDriver().navigate().to($x(EMAIL_CONFIRM_BUTTON).getAttribute("href"));
        Selenide.switchTo().defaultContent();
    }


}
