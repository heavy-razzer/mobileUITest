package helpers;

import io.qameta.allure.Attachment;
import objects.Colours;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

import static utils.Log.print;

/*
Custom actions, applied after test was executed
 */
public class TestWatchers extends TestWatcher {

    private WebDriver driver;

    public TestWatchers() {
        this.driver = BaseTest.driver;
    }

    // Actions after test was failed
    @Override
    protected void failed(Throwable e, Description description) {
        makeScreenshotOnFailure();
        print("     TEST FAILED", Colours.RED);
    }

    // Actions after test was successful
    @Override
    protected void succeeded(Description description) {
        print("     TEST SUCCEED", Colours.GREEN);
    }

    // Actions after test was skipped
    @Override
    protected void skipped(org.junit.AssumptionViolatedException e, Description description) {
        print("     TEST SKIPPED", Colours.BLUE);
    }

    // Get screenshot of opened web-page as Byte array
    @Attachment(value = "Screenshot on failure", type = "image/png", fileExtension = "png")
    private void makeScreenshotOnFailure() {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
