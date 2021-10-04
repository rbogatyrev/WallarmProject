package com.wallarm.steps;

import com.wallarm.pages.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {

    private HomePage landingPage = new HomePage();

    @Step("Click try for free")
    public void tryForFree(){
        landingPage.clickTryForFreeButton()
                .assertPageIsLoaded();
    }

    @Step("Go to Audit Page")
    public void goToAuditPage(){
        landingPage.getTopbar()
                .goToAuditPage()
                .assertPageIsLoaded();
    }

    @Step("Go to Partners page")
    public void goToPartnersPage(){
        landingPage.getTopbar().
                goToPartnersPage()
                .assertPageIsLoaded();
    }

    @Step("Go to Resources Page")
    public void goToResourcesPage(){
        landingPage.getTopbar().
                goToResourcesPage()
                .assertPageIsLoaded();
    }

    @Step("Go to Support Page")
    public void goToSupportPage(){
        landingPage.getTopbar()
                .goToSupportPage()
                .assertPageIsLoaded();
    }

}
