package com.wallarm.pages;

import com.wallarm.enums.Locals;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.wallarm.enums.Urls.WALLARM_PARTNERS_PAGE;
import static java.lang.String.format;

public class PartnersPage extends BasePage{

    private static final String MAIN_ELEMENT = "div[class*='section-main hero partners section']";
    private static final String PARTNERS_BUTTON = "a[href='#wallarm-partner']";
    private static final String FIRST_NAME_INPUT = "div#wallarm-partner input[name='firstname']";
    private static final String EMAIL_INPUT = "div#wallarm-partner input[name='email']";
    private static final String COMPANY_INPUT = "div#wallarm-partner input[name='company']";
    private static final String SEND_BUTTON = "div#wallarm-partner input[type='submit']";
    private static final String REQUEST_FORM_MESSAGE_SENT = "//div[@id='hubspot-form-container']//div[contains(@class,'submitted-message')]//p[contains(text(), '%s')]";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_PARTNERS_PAGE.getValue();
    }

    @Step("Click become partners")
    public PartnersPage clickBecomePartnersButton(){
        $(PARTNERS_BUTTON).click();
        return this;
    }

    @Step("Set user first name")
    public PartnersPage setFirstName(String firstName){
        $(FIRST_NAME_INPUT).scrollIntoView(true).setValue(firstName);
        return this;
    }

    @Step("Set user email")
    public PartnersPage setEmail (String email){
        $(EMAIL_INPUT).scrollIntoView(true).setValue(email);
        return this;
    }

    @Step("Set user company")
    public PartnersPage setCompany (String email){
        $(COMPANY_INPUT).scrollIntoView(true).setValue(email);
        return this;
    }

    @Step("Click send button")
    public PartnersPage clickSendButton(){
        $(SEND_BUTTON).click();
        return this;
    }

    public PartnersPage checkRequestIsSent(){
        $x(format(REQUEST_FORM_MESSAGE_SENT, Locals.WALLARM_REQUEST_SENT_MESSAGE.getValue())).shouldBe(visible);
        return this;
    }






}
