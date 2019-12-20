package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/*
Page for confirming use terms
 */
public class ConfirmOnboardingPage extends BasePage {

    private String TAG = "ConfirmOnboardingPage";

    public ConfirmOnboardingPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "btnConfirmOnboarding")
    private WebElement confirmButton;

    @Step("Wait for Confirm onboarding screen opened")
    public ConfirmOnboardingPage waitForOpening() {
        waitFor(confirmButton, "Confirm button", TAG);
        return this;
    }

    @Step("Wait to 'Confirm' button becomes enabled")
    public ConfirmOnboardingPage waitForConfirmButtonBecomeEnabled() {
        waitForElementToBeEnabled(confirmButton, 10, "Confirm button", TAG);
        return this;
    }

    @Step("Tap 'Confirm' button")
    public ConfirmOnboardingPage tapConfirmButton() {
        click(confirmButton, "Confirm button", TAG);
        return this;
    }
}
