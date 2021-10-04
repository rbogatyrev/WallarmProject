package com.wallarm.pages;

import com.wallarm.enums.Locals;

import static com.wallarm.enums.Urls.WALLARM_ACTIVATION_PAGE;
import static java.lang.String.format;

public class ActivationPage extends BasePage{

    private static final String MAIN_ELEMENT = "//h3[text()='%s']";

    @Override
    protected String getMainPageElement() {
        return format(MAIN_ELEMENT, Locals.WALLARM_SIGNUP_WELCOME_EN.getValue());
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_ACTIVATION_PAGE.getValue();
    }
}
