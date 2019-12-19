import org.junit.Test;
import test.BaseTest;

public class myTest extends BaseTest {

    @Test
    public void sampleTest() {

        loginPage
                .waitForOpening()
                .typePhoneNumber("56146994")
                .tapGetCodeButton();

        confirmDialog
                .waitForOpening()
                .tapYesButton();

        //String code = OsUtils.getSMSCode();
        //System.out.println("Code is :" + code);

    }
}
