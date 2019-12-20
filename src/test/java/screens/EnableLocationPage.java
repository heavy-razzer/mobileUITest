package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

public class EnableLocationPage extends BasePage {

    private String TAG = "EnableLocationPage";

    public EnableLocationPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "btnEnableLocation")
    private WebElement enableLocationServicesButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement dialogYesButton;

    @Step("Wait for Login screen opened")
    public EnableLocationPage waitForOpening() {
        waitFor(enableLocationServicesButton, "Enable location services button", TAG);
        return this;
    }

    @Step("Tap 'Enable location services button'")
    public EnableLocationPage tapEnableLocationButton() {
        click(enableLocationServicesButton, "Enable location services button", TAG);
        return this;
    }

    @Step("Tap 'Yes' in system 'Location' dialog")
    public EnableLocationPage acceptLocationDialog() {
        waitFor(dialogYesButton, "Location dialog Yes button", TAG);
        click(dialogYesButton, "Location dialog Yes button", TAG);
        return this;
    }

}
