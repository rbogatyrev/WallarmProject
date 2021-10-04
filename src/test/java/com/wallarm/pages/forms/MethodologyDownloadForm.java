package com.wallarm.pages.forms;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MethodologyDownloadForm {

    private static final String MAIN_ELEMENT = "[data-w-id='c3f58183-c59e-0e34-605e-f151138a9933'] div[class*='hbspt-form-container']";
    private static final String FRAME = "[data-w-id='c3f58183-c59e-0e34-605e-f151138a9933'] div[class*='hbspt-form-container'] iframe";
    private static final String FRAME_TEXT = "#hubspot-form-container div[class*='submitted-message'] p";
    private static final String NAME_INPUT = "input[name='firstname']";
    private static final String JOB_TITLE_INPUT = "input[name='jobtitle']";
    private static final String EMAIL_INPUT = "input[name='email']";
    private static final String SUBMIT_BUTTON = "input[type='submit']";

    public String getFormText(){
       $(FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(FRAME));
        return $(FRAME_TEXT).text();

    }

    public MethodologyDownloadForm setName(String name){
        $(FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(FRAME));
        $(NAME_INPUT).shouldBe(visible).sendKeys(name);
        Selenide.switchTo().defaultContent();
        return this;
    }
    public MethodologyDownloadForm setPosition(String name){
        $(FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(FRAME));
        $(JOB_TITLE_INPUT).sendKeys(name);
        Selenide.switchTo().defaultContent();
        return this;
    }

    public MethodologyDownloadForm setEmail(String name){
        $(FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(FRAME));
        $(EMAIL_INPUT).sendKeys(name);
        Selenide.switchTo().defaultContent();
        return this;
    }
    public MethodologyDownloadForm clickDownloadButton(){
        $(FRAME).shouldBe(visible);
        Selenide.switchTo().frame($(FRAME));
        $(SUBMIT_BUTTON).click();
        Selenide.switchTo().defaultContent();
        return this;
    }



}
