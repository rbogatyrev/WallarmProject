package com.wallarm.pages;

import com.wallarm.pages.forms.MethodologyDownloadForm;

import static com.codeborne.selenide.Selenide.$;
import static com.wallarm.enums.Urls.WALLARM_AUDIT_PAGE;

public class AuditPage extends BasePage {

    private static final String MAIN_ELEMENT = "div#audit-request-form";
    private static final String WEB_API_TESTING_BUTTON = "a[data-w-id='e692bcd6-b356-35ff-6870-37e05f65a570']";

    private MethodologyDownloadForm methodologyDownloadForm = new MethodologyDownloadForm();

    @Override
    protected String getMainPageElement() {
     return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_AUDIT_PAGE.getValue();
    }

    public MethodologyDownloadForm clickWebApiMethodologyButton(){
        $(WEB_API_TESTING_BUTTON).click();
        return methodologyDownloadForm;
    }

    public MethodologyDownloadForm getMethodologyDownloadForm(){
        return methodologyDownloadForm;
    }
}
