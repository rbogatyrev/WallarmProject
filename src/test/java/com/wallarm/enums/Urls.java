package com.wallarm.enums;

public enum Urls implements IEnumValue{

    WALLARM_HOMEPAGE("https://www.wallarm.ru/"),
    MAILINATOR_MAINPAGE("https://www.mailinator.com/"),
    WALLARM_ACTIVATION_PAGE("https://us1.my.wallarm.com/activate"),
    WALLARM_SIGNUP_PAGE("https://us1.my.wallarm.com/signup"),
    WALLARM_LOGIN_PAGE("https://us1.my.wallarm.com/login"),
    WALLARM_ACCOUNT_PAGE("https://us1.my.wallarm.com/"),
    WALLARM_SUPPORT_PAGE("https://www.wallarm.ru/support"),
    WALLARM_SERVICE_DESK_LOGINPAGE("https://wallarm.atlassian.net/servicedesk/customer/user/login?destination=portals"),
    WALLARM_AUDIT_PAGE("https://www.wallarm.ru/audit"),
    WALLARM_PARTNERS_PAGE("https://www.wallarm.ru/product/partners"),
    WALLARM_RESOURCES_PAGE("https://www.wallarm.ru/resources"),
    WALLARM_SUCCESS_CASES_PAGE("https://www.wallarm.ru/success-cases"),
    WALLARM_DOCS_PAGE("https://docs.wallarm.ru");

    private String urlKey;

    Urls(String urlKey) {
        this.urlKey = urlKey;
    }

    @Override
    public String getValue() {
        return this.urlKey;
    }
}
