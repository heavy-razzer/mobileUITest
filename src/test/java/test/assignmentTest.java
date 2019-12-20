package test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import objects.MSG;
import objects.MenuItems;
import org.junit.Assert;
import org.junit.Test;
import utils.OsUtils;

@Epic("UI Assignment for SDET")
public class assignmentTest extends BaseTest {

    @Test
    @Description("Complete login and registration flow, open Rules and accept it, open Profile and sign out.")
    @Severity(SeverityLevel.BLOCKER)
    public void sampleTest() {

        String phoneNumber = OsUtils.getPhoneNumber();
        String emailId = OsUtils.getEmail();

        loginPage
                .waitForOpening()
                .typePhoneNumber(phoneNumber)
                .tapGetCodeButton();

        confirmDialog
                .waitForOpening()
                .tapYesButton();

        String verificationCode = OsUtils.getSMSCodeFromNotification();
        Assert.assertNotNull(MSG.ERR_NO_SMS_CODE.getMessageText(), verificationCode);

        verificationPage
                .waitForOpening()
                .typeVerificationCode(verificationCode);

        emailPage
                .waitForOpening()
                .typeEmailAddress(emailId)
                .tapLetsGoButton();

        confirmDialog
                .waitForOpening()
                .tapYesButton();

        confirmOnboardingPage
                .waitForOpening()
                .waitForConfirmButtonBecomeEnabled()
                .tapConfirmButton();

        enableLocationPage
                .waitForOpening()
                .tapEnableLocationButton()
                .acceptLocationDialog();

        homePage
                .skipZoneOnboarding()
                .waitForOpening()
                .openMenu()
                .selectMenuItem(MenuItems.RULES);

        confirmOnboardingPage
                .waitForOpening()
                .tapConfirmButton();

        homePage
                .waitForOpening()
                .openMenu()
                .selectMenuItem(MenuItems.PROFILE);

        profilePage
                .waitForOpening()
                .tapSignOutButton();

        confirmDialog
                .waitForOpening()
                .tapYesButton();

        loginPage
                .waitForOpening();
    }
}
