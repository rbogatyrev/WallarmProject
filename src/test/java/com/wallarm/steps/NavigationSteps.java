package com.wallarm.steps;

import com.wallarm.pages.HomePage;
import io.qameta.allure.Step;

public class NavigationSteps {

    private HomePage landingPage = new HomePage();

    @Step("Go to Wallarm Home page")
    public void openHomePage(){
        landingPage.open();
        landingPage.assertPageIsLoaded();
    }
}
