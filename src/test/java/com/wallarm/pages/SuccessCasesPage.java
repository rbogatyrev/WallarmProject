package com.wallarm.pages;

import com.wallarm.enums.SuccessCase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.wallarm.enums.Urls.WALLARM_SUCCESS_CASES_PAGE;
import static java.lang.String.format;

public class SuccessCasesPage extends BasePage{

    private static final String MAIN_ELEMENT = "#w-node-f86aad1d-c1d4-5351-aa9a-80ef8f6fb30d-cc8301c6";
    private static final String SUCCESS_CASE_READ_MORE = "#resource-library a[href*='%s'] div[class*='text-block']";
    private static final String SUCCESS_CASE_TITLE = "[class*='section-main case'] > h2[class*='section-title']";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_SUCCESS_CASES_PAGE.getValue();
    }

    public SuccessCasesPage clickReadMoreButton(SuccessCase successCase){
        $(format(SUCCESS_CASE_READ_MORE, successCase.getUrlPart())).shouldBe(visible).click();
        return this;
    }

    public String getSuccessCaseTitle(){
       return $(SUCCESS_CASE_TITLE).shouldBe(visible).getText();
    }


}
