package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

/*
Users profile page
 */
public class ProfilePage extends BasePage {

    private String TAG = "ProfilePage";

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "logoutButton")
    private WebElement signOutButton;

    @Step("Wait for Profile screen opened")
    public ProfilePage waitForOpening() {
        waitFor(signOutButton, "Sign out button", TAG);
        return this;
    }

    @Step("Tap 'Sign out' button")
    public ProfilePage tapSignOutButton() {
        click(signOutButton, "Sign out button", TAG);
        return this;
    }
}
