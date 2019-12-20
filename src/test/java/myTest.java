import drivers.DriverSleep;
import objects.MenuItems;
import org.junit.Test;
import test.BaseTest;

public class myTest extends BaseTest {

    @Test
    public void sampleTest() {

        DriverSleep.sleep(9000);

        loginPage
                .waitForOpening()
                .typePhoneNumber("8602079805")
                .tapGetCodeButton();

        confirmDialog
                .waitForOpening()
                .tapYesButton();

        verificationPage
                .waitForOpening();

        DriverSleep.sleep(15000);

        emailPage
                .waitForOpening()
                .typeEmailAddress("voitest4@email5.net")
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

        //String code = OsUtils.getSMSCode();
        //System.out.println("Code is :" + code);

        //homePage.waitForOpening().openMenu();
    }
}
