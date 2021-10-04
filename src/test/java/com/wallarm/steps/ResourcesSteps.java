package com.wallarm.steps;

import com.wallarm.entities.User;
import com.wallarm.enums.Infographics;
import com.wallarm.enums.Locals;
import com.wallarm.enums.SuccessCase;
import com.wallarm.pages.ResourcesPage;
import io.qameta.allure.Step;
import org.assertj.core.api.AssertionsForClassTypes;
import org.jetbrains.annotations.NotNull;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ResourcesSteps {

    private ResourcesPage resourcesPage = new ResourcesPage();

    @Step("Go to success case tab")
    public void goToSuccessCase(SuccessCase successCase){
        resourcesPage.goToSuccessCasesTab()
                .clickReadMoreButton(successCase);
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
