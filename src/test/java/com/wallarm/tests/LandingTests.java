package com.wallarm.tests;

import com.wallarm.entities.User;
import com.wallarm.enums.Infographics;
import com.wallarm.enums.SuccessCase;
import com.wallarm.steps.*;
import com.wallarm.utils.DriverHelper;
import com.wallarm.utils.UserGenerator;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LandingTests extends BaseTest {

    private NavigationSteps navigationSteps = new NavigationSteps();
    private HomePageSteps landingSteps = new HomePageSteps();
    private RegistrationSteps registrationSteps = new RegistrationSteps();
    private MailSteps mailSteps = new MailSteps();
    private PageLoadSteps pageLoadingAssertions = new PageLoadSteps();
    private AuditSteps auditSteps = new AuditSteps();
    private PartnersSteps partnersSteps = new PartnersSteps();
    private ResourcesSteps resourcesSteps = new ResourcesSteps();
    private SupportSteps supportSteps = new SupportSteps();


    @Test
    @DisplayName("Register a new Wallarm user")
    @Description("Registering a new Wallarm user and checking the user is authorized in personal account " +
            "after following the link in the confirmation letter")
    public void testRegisterAndConfirmNewUser() {
        User user = UserGenerator.generateRandomUserProfileWithMailinator();

        navigationSteps.openHomePage();
        landingSteps.tryForFree();
        registrationSteps.registerNewUserWithWait(user);
        DriverHelper.switchToBlankTab();
        mailSteps.goToMailInbox(user.getEmail());
        mailSteps.confirmEmail();
        pageLoadingAssertions.assertAccountPageIsLoaded();
    }

    @Test
    @DisplayName("Send support ticket from Wallarm website")
    @Description("Checking that user is redirected to technical support login page after sending support ticket")
    public void testSendSupportTicket() {

        navigationSteps.openHomePage();
        landingSteps.goToSupportPage();
        supportSteps.sendSupportTicket();
        pageLoadingAssertions.assertSupportLoginPageIsLoaded();

    }

    @Test
    @DisplayName("Download methodology 'Testing API and Web Application' from 'Audit' section")
    @Description("Checking that 'Methodology is sent to specific email' message appeared after it was downloaded")
    public void testWebAPITestingMethodologyDownloadInformation() {
        User user = UserGenerator.generateRandomUserProfileWithYandexMail();

        navigationSteps.openHomePage();
        landingSteps.goToAuditPage();
        auditSteps.downloadWebApiTestingMethodology(user);
        auditSteps.assertMethodologyIsDownloaded();
    }

    @Test
    @DisplayName("Send become Wallarm partner request")
    @Description("Sending become Wallarm partner request from 'Partners' section")
    public void testSendingPartnerRequestForm() {
        User user = UserGenerator.generateRandomUserProfileWithYandexMail();

        navigationSteps.openHomePage();
        landingSteps.goToPartnersPage();
        partnersSteps.sendBecomePartnersForm(user);
        partnersSteps.assertRequestIsSent();
    }

    @Test
    @DisplayName("Go to Wallarm documentation page from website")
    public void testGoToDocumentationPageFromLanding() {
        navigationSteps.openHomePage();
        landingSteps.goToSupportPage();
        supportSteps.clickDocumentationButton();
        pageLoadingAssertions.assertDocumentationPageIsLoaded();

    }

    @ParameterizedTest(name = "{0} Success Case Title Test")
    @MethodSource("com.wallarm.tests.TestDataProvider#getSuccessCasesData")
    public void testSuccessCaseTitle(SuccessCase successCase) {

        navigationSteps.openHomePage();
        landingSteps.goToResourcesPage();
        resourcesSteps.goToSuccessCase(successCase);
        resourcesSteps.assertSuccessCaseHasText(successCase.getHeaderMessage());

    }

    @ParameterizedTest(name = "{0} Infographics download")
    @MethodSource("com.wallarm.tests.TestDataProvider#getInfographicsData")
    public void testSuccessInfographycsDownloadMessage(Infographics infographics) {
        User user = UserGenerator.generateRandomUserProfileWithYandexMail();

        navigationSteps.openHomePage();
        landingSteps.goToResourcesPage();
        resourcesSteps.downloadInfographics(infographics, user);
        resourcesSteps.assertInfographicsDownloadMessageIsDisplayed();
    }

}


