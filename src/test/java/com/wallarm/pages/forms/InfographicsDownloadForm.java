package com.wallarm.pages.forms;

import static com.codeborne.selenide.Selenide.$;

public class InfographicsDownloadForm {

    private static final String FIRSTNAME_INPUT = "input[name='firstname']";
    private static final String LASTNAME_INPUT = "input[name='lastname']";
    private static final String JOB_TITLE_INPUT = "input[name='jobtitle']";
    private static final String COMPANY_NAME_INPUT = "input[name='company']";
    private static final String EMAIL_INPUT = "input[name='email']";
    private static final String PHONE_INPUT = "input[name='phone']";
    private static final String SUBMIT_BUTTON = "input[type='submit']";
    private static final String FORM_MESSAGE = "#hubspot-form-container div[class*='submitted-message'] p:nth-child(2)";

    public InfographicsDownloadForm setFirstName(String firstName){
        $(FIRSTNAME_INPUT).setValue(firstName);
        return this;
    }

    public InfographicsDownloadForm setLastName(String lastName){
        $(LASTNAME_INPUT).setValue(lastName);
        return this;
    }

    public InfographicsDownloadForm setJobTitle(String jobTitle){
        $(JOB_TITLE_INPUT).setValue(jobTitle);
        return this;
    }

    public InfographicsDownloadForm setCompanyName(String companyName){
        $(COMPANY_NAME_INPUT).setValue(companyName);
        return this;
    }

    public InfographicsDownloadForm setEmail(String email){
        $(EMAIL_INPUT).setValue(email);
        return this;
    }

    public InfographicsDownloadForm setPhone(String phone){
        $(PHONE_INPUT).setValue(phone);
        return this;
    }

    public InfographicsDownloadForm clickDownloadButton(){
        $(SUBMIT_BUTTON).click();
        return this;
    }

    public String getFormText(){
        return $(FORM_MESSAGE).text();

    }


}
