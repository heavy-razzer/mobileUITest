package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/*
Start page for entering phone number
 */
public class LoginPage extends BasePage {

    private String TAG = "LoginPage";

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "etPhoneNumber")
    private WebElement phoneEditField;

    @AndroidFindBy(id = "tvCountryCode")
    private WebElement countryCodeButton;

    @AndroidFindBy(id = "btnGetCode")
    private WebElement getCodeButton;

    @Step("Wait for Login screen opened")
    public LoginPage waitForOpening() {
        waitFor(phoneEditField, "Phone edit field", TAG);
        return this;
    }

    @Step("Type phone {phone}")
    public LoginPage typePhoneNumber(String phone) {
        type(phoneEditField, phone, "Phone edit field", TAG);
        return this;
    }

    @Step("Tap 'Get Code' button")
    public LoginPage tapGetCodeButton() {
        click(getCodeButton, "Get code button", TAG);
        return this;
    }
}
