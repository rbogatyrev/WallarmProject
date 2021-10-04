package com.wallarm.steps;

import com.wallarm.pages.InboxPage;
import com.wallarm.pages.MailPage;
import io.qameta.allure.Step;

import static com.wallarm.enums.Locals.WALLARM_EMAIL_CONFIRMATION_SUBJECT_EN;

public class MailSteps {

   private MailPage mailPage = new MailPage();
    private InboxPage inboxPage = new InboxPage();

    @Step("Go to {email} inbox page")
    public void goToMailInbox(String email){
        mailPage.open();
        mailPage.assertPageIsLoaded();
        mailPage.enterInbox(email)
                .clickGoButton();
    }

    @Step("Navigate to link from the confirmation email")
    public void confirmEmail(){
        String confirmationSubject = WALLARM_EMAIL_CONFIRMATION_SUBJECT_EN.getValue();
        inboxPage.waitForMessageWithSubjectReceived(confirmationSubject);
        inboxPage.clickOnEmailConfirmLink();
    }

}
