package com.wallarm.pages;


import com.wallarm.pages.forms.InfographicsDownloadForm;

import static com.codeborne.selenide.Selenide.$;
import static com.wallarm.enums.Urls.WALLARM_RESOURCES_PAGE;
import static java.lang.String.format;


public class ResourcesPage extends BasePage{

    private static final String MAIN_ELEMENT = "#resource-library";
    private static final String TRY_FOR_FREE_BUTTON = "[data-w-id='79d46dd5-77c9-4ba1-5e04-dc2e2222fb6f'] a[href*='signup']";
    private static final String REQUEST_DEMO_BUTTON = "[data-w-id='79d46dd5-77c9-4ba1-5e04-dc2e2222fb6f'] a[href='/request-demo']";
    private static final String TAB_BUTTON = ".tabs-menu.w-tab-menu a[data-w-tab='%s']";
    private static final String INFOGRAPHICS_DOWNLOAD_BUTTON = "div[role='listitem'] a[href*='%s'] div[class*='text-block']";

    private SuccessCasesPage successCasesPage = new SuccessCasesPage();
    private InfographicsDownloadForm infographicsDownloadForm = new InfographicsDownloadForm();

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_RESOURCES_PAGE.getValue();
    }

    public ResourcesPage goToAllTab(){
        $(format(TAB_BUTTON, "all")).click();
        return this;
    }
    public SuccessCasesPage goToSuccessCasesTab(){
        $(format(TAB_BUTTON, "case-studies")).click();
        return successCasesPage;
    }

    public InfographicsDownloadForm clickInfographyDownloadButton(String urlPart){
        $(format(INFOGRAPHICS_DOWNLOAD_BUTTON, urlPart)).click();
        return infographicsDownloadForm;
    }

    public SuccessCasesPage getSuccessCasesTab(){
        return  successCasesPage;
    }
    public InfographicsDownloadForm getInfographicsDownloadForm(){return infographicsDownloadForm; }



}
