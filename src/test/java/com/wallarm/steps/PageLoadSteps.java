package com.wallarm.steps;

import com.wallarm.pages.AccountPage;
import com.wallarm.pages.DocumentationPage;
import com.wallarm.pages.ServiceDeskLoginPage;
import io.qameta.allure.Step;

public class PageLoadSteps {

    private AccountPage accountPage = new AccountPage();
    private  ServiceDeskLoginPage serviceDeskLoginPage = new ServiceDeskLoginPage();
    private DocumentationPage documentationPage = new DocumentationPage();

    @Step("Assert that Wallarm Dashboard page is loaded")
    public void assertAccountPageIsLoaded(){
        accountPage.assertPageIsLoaded();
    }

    @Step("Assert that technical support login page is loaded")
    public void assertSupportLoginPageIsLoaded(){
        serviceDeskLoginPage.assertPageIsLoaded();
    }

    @Step("Assert that documentation page is loaded")
    public void assertDocumentationPageIsLoaded(){
        documentationPage.assertPageIsLoaded();
    }
}
