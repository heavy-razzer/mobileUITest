package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/*
Confirm dialog with Yes/No buttons
 */
public class ConfirmDialog extends BasePage {

    private String TAG = "ConfirmDialog";

    public ConfirmDialog() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "confirmDialogTitleTv")
    private WebElement titleText;

    @AndroidFindBy(id = "confirmDialogYesBtn")
    private WebElement yesButton;

    @AndroidFindBy(id = "confirmDialogNoBtn")
    private WebElement noButton;

    @Step("Wait for confirm dialog opened")
    public ConfirmDialog waitForOpening() {
        waitFor(titleText, "Dialog title", TAG);
        return this;
    }

    @Step("Tap 'Yes' button")
    public ConfirmDialog tapYesButton() {
        click(yesButton, "Yes button", TAG);
        return this;
    }

    @Step("Tap 'No' button")
    public ConfirmDialog tapNoButton() {
        click(noButton, "No button", TAG);
        return this;
    }
}
