package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/*
Page to enter verification code from sms
 */
public class VerificationPage extends BasePage {

    private String TAG = "VerificationPage";

    public VerificationPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "etVerificationCode")
    private WebElement codeEditField;

    @Step("Wait for Verification code screen opened")
    public VerificationPage waitForOpening() {
        waitFor(codeEditField, "Verification code edit field", TAG);
        return this;
    }

    @Step("Type verification code {code}")
    public VerificationPage typeVerificationCode(String code) {
        type(codeEditField, code, "Verification code edit field", TAG);
        return this;
    }
}
