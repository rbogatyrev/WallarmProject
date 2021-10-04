package com.wallarm.enums;

public enum Infographics implements IEnumValue{
    FINTECH_COMPANIES_INFOSECURITY("informacionnaya-bezopasnost-finteh-kompaniy"),
    RUSSIAN_COMPANIES_CYBER_RISKS("kiber-riski-ugrozhayushchie-rossiyskim-kompaniyam") ;

    private String urlPart;

    Infographics(String urlPart){
        this.urlPart = urlPart;
    }

    @Override
    public String getValue() {
        return urlPart;
    }
}
