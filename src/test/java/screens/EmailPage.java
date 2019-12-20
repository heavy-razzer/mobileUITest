package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/*
Page to enter email address
 */
public class EmailPage extends BasePage {

    private String TAG = "EmailPage";

    public EmailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "etEmailAddress")
    private WebElement emailAddressEditField;

    @AndroidFindBy(id = "btnGetCode")
    private WebElement letsGoButton;

    @Step("Wait for Email address screen opened")
    public EmailPage waitForOpening() {
        waitFor(emailAddressEditField, "Email address edit field", TAG);
        return this;
    }

    @Step("Type email address {email}")
    public EmailPage typeEmailAddress(String email) {
        type(emailAddressEditField, email, "Email address edit field", TAG);
        return this;
    }

    @Step("Tap 'Lets go' button")
    public EmailPage tapLetsGoButton() {
        click(letsGoButton, "Lets go button", TAG);
        return this;
    }
}
