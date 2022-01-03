package com.wallarm.steps;

import com.wallarm.entities.User;
import com.wallarm.enums.Infographics;
import com.wallarm.enums.Locals;
import com.wallarm.enums.SuccessCase;
import com.wallarm.pages.ResourcesPage;
import com.wallarm.pages.SuccessCasesPage;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ResourcesSteps {

    private ResourcesPage resourcesPage = new ResourcesPage();
    private SuccessCasesPage successCasesPage = new SuccessCasesPage();

    @Step("Go to success case from resource page")
    public void goToSuccessCase(SuccessCase successCase){
        successCasesPage.clickReadMoreButton(successCase);
    }

    @Step("Assert that the success case title has a specific text")
    public void assertSuccessCaseHasText(String expectedText){
        String caseTitle = resourcesPage.getSuccessCasesTab().getSuccessCaseTitle().replace("\n", " ");
        assertThat(caseTitle).as("Текст текущего заголовка страницы '%s' не совпадает с ожидаемым '%s'", caseTitle, expectedText).hasToString(expectedText);
    }

    @Step("Download infographics '{infographics}'")
    public void downloadInfographics(@NotNull Infographics infographics, @NotNull User user){
        resourcesPage.clickInfographyDownloadButton(infographics.getValue())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setCompanyName(user.getCompanyName())
                .setPhone(user.getPhone())
                .setEmail(user.getEmail())
                .setJobTitle(user.getPosition())
                .clickDownloadButton();
    }

    @Step("Assert that infographics download success message is displayed")
    public void assertInfographicsDownloadMessageIsDisplayed(){
       String formText = resourcesPage.getInfographicsDownloadForm().getFormText();
       assertThat(formText).as("Infographics download message didn't appear")
               .isEqualTo(Locals.WALLARM_THANKS_FOR_FILLING_FORM_MESSAGE_RU.getValue());
    }
}
