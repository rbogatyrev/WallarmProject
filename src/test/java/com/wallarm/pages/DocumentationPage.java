package com.wallarm.pages;


import static com.wallarm.enums.Locals.WALLARM_DOCSPAGE_TITLE_RU;
import static com.wallarm.enums.Urls.WALLARM_DOCS_PAGE;
import static java.lang.String.format;

public class DocumentationPage extends BasePage{

    private static final String MAIN_ELEMENT = "//div[@class='md-header-nav__title']//span[text()=' %s ']";
    private static final String WEB_API_TESTING_BUTTON = "a[data-w-id='e692bcd6-b356-35ff-6870-37e05f65a570']";

    @Override
    protected String getMainPageElement() {
        return format(MAIN_ELEMENT,WALLARM_DOCSPAGE_TITLE_RU.getValue());
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_DOCS_PAGE.getValue();
    }
}
