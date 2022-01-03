package com.wallarm.steps;

import com.wallarm.entities.User;
import com.wallarm.pages.AuditPage;
import com.wallarm.pages.forms.MethodologyDownloadForm;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static com.wallarm.enums.Locals.WALLARM_THANKS_FOR_FILLING_FORM_MESSAGE_RU;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AuditSteps {

    private AuditPage auditPage = new AuditPage();
    private MethodologyDownloadForm methodologyDownloadForm = new MethodologyDownloadForm();

    @Step("Download Web Api Testing Methodology")
    public void downloadWebApiTestingMethodology(@NotNull User user){
        methodologyDownloadForm
                .setEmail(user.getEmail())
                .setPosition(user.getPosition())
                .setName(user.getFirstName())
                .clickDownloadButton();
    }

    @Step("Assert that methodology download success message is displayed")
    public void assertMethodologyIsDownloaded(){
        String formText = auditPage.getMethodologyDownloadForm().getFormText();
        String expectedText = WALLARM_THANKS_FOR_FILLING_FORM_MESSAGE_RU.getValue();
        assertThat(formText).as("The methodology download form text '%s' doesn't equal to the expected one '%s'", formText, expectedText)
                .isEqualTo(expectedText);
    }

}
