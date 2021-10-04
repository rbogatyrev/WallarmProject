package com.wallarm.pages;

import static com.wallarm.enums.Urls.WALLARM_SERVICE_DESK_LOGINPAGE;

public class ServiceDeskLoginPage extends BasePage{

    private static final String MAIN_ELEMENT = "[data-test-id='login-page.wrapper']";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_SERVICE_DESK_LOGINPAGE.getValue();
    }
}
