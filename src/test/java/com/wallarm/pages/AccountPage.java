package com.wallarm.pages;


import static com.wallarm.enums.Urls.WALLARM_ACCOUNT_PAGE;

public class AccountPage extends BasePage{

    private static final String MAIN_ELEMENT = "[data-test-id='navigation.dashboard']";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_ACCOUNT_PAGE.getValue();
    }
}
