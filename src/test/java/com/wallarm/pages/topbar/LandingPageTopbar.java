package com.wallarm.pages.topbar;

import com.wallarm.pages.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LandingPageTopbar {

    private static final String MAIN_ELEMENT = ".nav-menu-links";
    private static final String RESOURCES_DROPDOWN_MENU = "#w-dropdown-list-2";
    private static final String SUPPORT = RESOURCES_DROPDOWN_MENU + " a[href='/support']";
    private static final String INFOGRAPHICS = RESOURCES_DROPDOWN_MENU + " a[href='/resources?tab=infographics#resources']";
    private static final String SUCCESS_CASE = RESOURCES_DROPDOWN_MENU + " a[href='/success-cases']";
    private static final String AUDIT = MAIN_ELEMENT + " a[href='/audit']";
    private static final String PARTNERS = MAIN_ELEMENT + " a[href='/product/partners']";
    private static final String RESOURCES = MAIN_ELEMENT + " [data-w-id='2fd490b1-df37-55fe-384e-c637ccf3c8cd']";

    private SupportPage supportPage = new SupportPage();
    private AuditPage auditPage = new AuditPage();
    private PartnersPage partnersPage = new PartnersPage();
    private ResourcesPage resourcesPage = new ResourcesPage();
    private SuccessCasesPage successCasesPage = new SuccessCasesPage();

    public SupportPage goToSupportPage(){
        $(RESOURCES).hover();
        $(SUPPORT).shouldBe(visible).click();
        return supportPage;
    }

    public AuditPage goToAuditPage(){
        $(AUDIT).click();
        return auditPage;
    }

    public PartnersPage goToPartnersPage(){
        $(PARTNERS).click();
        return partnersPage;
    }

    public SuccessCasesPage goToSuccessCasesPage(){
        $(RESOURCES).hover();
        $(SUCCESS_CASE).shouldBe(visible).click();
        return successCasesPage;
    }

    public ResourcesPage goToInfographicsTab(){
        $(RESOURCES).hover();
        $(INFOGRAPHICS).shouldBe(visible).click();
        return resourcesPage;
    }

}
