package com.wallarm.pages;

import com.wallarm.pages.topbar.LandingPageTopbar;

import static com.codeborne.selenide.Selenide.$;
import static com.wallarm.enums.Urls.WALLARM_HOMEPAGE;

public class HomePage extends BasePage {

    private static final String MAIN_ELEMENT = "[data-w-id='d0b3405e-d6fd-e77c-f1e1-c1f58aba9c10']";
    private static final String TRY_FOR_FREE_BUTTON = "[data-w-id='79d46dd5-77c9-4ba1-5e04-dc2e2222fb6f'] a[href*='signup']";
    private static final String REQUEST_DEMO_BUTTON = "[data-w-id='79d46dd5-77c9-4ba1-5e04-dc2e2222fb6f'] a[href='/request-demo']";
    private static final String SUPPORT_TAB_BUTTON = "#w-node-_7804556d-acfe-cb9f-ace7-88c72abe57a1-a3fed1d5 a[href='/support']";

    private RegistrationPage signupPage = new RegistrationPage();
    private LandingPageTopbar landingPageTopbar = new LandingPageTopbar();


    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_HOMEPAGE.getValue();
    }

    public RegistrationPage clickTryForFreeButton() {
        $(TRY_FOR_FREE_BUTTON).click();
        return signupPage;
    }

    public void clickRequestDemoButton() {
        $(REQUEST_DEMO_BUTTON).click();
    }

    public LandingPageTopbar getTopbar() {
        return this.landingPageTopbar;
    }
}
