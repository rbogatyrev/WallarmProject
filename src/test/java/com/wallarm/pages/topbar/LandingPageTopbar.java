package com.wallarm.pages.topbar;

import com.wallarm.pages.AuditPage;
import com.wallarm.pages.PartnersPage;
import com.wallarm.pages.ResourcesPage;
import com.wallarm.pages.SupportPage;

import static com.codeborne.selenide.Selenide.$;

public class LandingPageTopbar {

    private static final String MAIN_ELEMENT = ".nav-menu-links";
    private static final String SUPPORT = MAIN_ELEMENT + " a[href='/support']";
    private static final String AUDIT = MAIN_ELEMENT + " a[href='/audit']";
    private static final String PARTNERS = MAIN_ELEMENT + " a[href='/product/partners']";
    private static final String RESOURCES = MAIN_ELEMENT + " a[href='/resources']";

    private SupportPage supportPage = new SupportPage();
    private AuditPage auditPage = new AuditPage();
    private PartnersPage partnersPage = new PartnersPage();
    private ResourcesPage resourcesPage = new ResourcesPage();

    public SupportPage goToSupportPage(){
        $(SUPPORT).click();
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

    public ResourcesPage goToResourcesPage(){
        $(RESOURCES).click();
        return resourcesPage;
    }

}
