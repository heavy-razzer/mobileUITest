package Screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

public class LoginPage extends BasePage {

    private String TAG = "LoginPage";

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "etPhoneNumber")
    private WebElement phoneEditField;

    @Step("Wait for Login screen opened")
    public LoginPage waitForOpening() {
        waitFor(phoneEditField, "Login screen", TAG);
        return this;
    }

    @Step("Type phone {phone}")
    public LoginPage typePhoneNumber(String phone) {
        type(phoneEditField, "123", "Phone edit field", TAG);
        return this;
    }


}
