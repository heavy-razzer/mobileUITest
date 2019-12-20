package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.BaseTest;

import java.util.List;

public class HomePage extends BasePage {

    private String TAG = "HomePage";

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.driver), this);
    }

    @AndroidFindBy(id = "actionBarMenu")
    private WebElement menuButton;

    @AndroidFindBy(id = "design_menu_item_text")
    private List<WebElement> menuItems;

    @AndroidFindBy(id = "rideButton")
    private WebElement scanToRideButton;

    @AndroidFindBy(id = "rvZoneOnboarding")
    private WebElement zoneOnboardingPanel;

    @Step("Wait for Login screen opened")
    public HomePage waitForOpening() {
        waitFor(scanToRideButton, "Scan to ride button", TAG);
        return this;
    }

    @Step("Close zone onboarding")
    public HomePage skipZoneOnboarding() {
        waitFor(zoneOnboardingPanel, "Zone onboarding panel", TAG);
        zoneOnboardingPanel.findElement(By.className("android.widget.Button")).click();
        zoneOnboardingPanel.findElement(By.className("android.widget.Button")).click();
        return this;
    }

    @Step("Open menu")
    public HomePage openMenu() {
        click(menuButton, "Hamburger icon", TAG);
        return this;
    }

    @Step("Select ")
    public HomePage selectMenuItem() {

        return this;
    }
}
