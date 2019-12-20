import drivers.DriverSleep;
import org.junit.Test;
import test.BaseTest;

public class myTest extends BaseTest {

    @Test
    public void sampleTest() {

        DriverSleep.sleep(9000);

        loginPage
                .waitForOpening()
                .typePhoneNumber("6467879865")
                .tapGetCodeButton();

        confirmDialog
                .waitForOpening()
                .tapYesButton();

        verificationPage
                .waitForOpening();

        DriverSleep.sleep(15000);

        emailPage
                .waitForOpening()
                .typeEmailAddress("voitest3@email5.net")
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
                .openMenu();


        //String code = OsUtils.getSMSCode();
        //System.out.println("Code is :" + code);

        //homePage.waitForOpening().openMenu();

        /*
        emailPage
                .waitForOpening()
                .typeEmailAddress("voitest@email5.net")
                .tapLetsGoButton();

        confirmOnboardingPage
                .waitForOpening()
                .waitForConfirmButtonBecomeEnabled()
                .tapConfirmButton();

         */

        DriverSleep.sleep(5000);

    }
}
