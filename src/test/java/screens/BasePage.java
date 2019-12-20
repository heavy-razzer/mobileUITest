package screens;

import io.qameta.allure.Step;
import objects.Colours;
import objects.MSG;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

import static objects.DateFormats.SHORT_TIME;
import static utils.Log.errLog;
import static utils.Log.log;
import static utils.OsUtils.timeStamp;


/*
Contains basic element functions, that are used in each test.
Used to apply actions and handle error in one place
 */
class BasePage {

    @Step("Click on '{description}'")
    static void click(WebElement element, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Click '"
                + Colours.CYAN.getColour()
                + description
                + Colours.DEFAULT.getColour()
                + "'");
        try {
            element.click();
        } catch (WebDriverException e) {
            System.out.println(e.toString());
            errLog(MSG.ERR_CLICK_FAILED, description);
        }
    }

    @Step("Wait for element '{description}'")
    static void waitFor(WebElement element, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Wait for '"
                + Colours.CYAN.getColour()
                + description
                + Colours.DEFAULT.getColour()
                + "'");
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, 5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            errLog(timeStamp(SHORT_TIME)
                    + " - "
                    + tag
                    + ": Failed to wait for element appears on screen '"
                    + description
                    + "'");
        }
    }

    @Step("Type '{text}' text to element '{description}'")
    static void type(WebElement element, String text, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Type '"
                + Colours.PURPLE.getColour() + text + Colours.DEFAULT.getColour()
                + "' to '"
                + Colours.CYAN.getColour() + description + Colours.DEFAULT.getColour()
                + "'");
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            System.out.println(e.toString());
            errLog(timeStamp(SHORT_TIME)
                    + " - "
                    + tag
                    + ": Failed to insert '"
                    + text
                    + "' to '"
                    + description
                    + "'");
        }
    }

    @Step("Wait for element '{description}' to be enabled in {timeOut} seconds")
    static void waitForElementToBeEnabled(WebElement element, int timeOut, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Wait for '"
                + Colours.CYAN.getColour()
                + description
                + Colours.DEFAULT.getColour()
                + "' to be enabled");
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, timeOut);
        try {
            wait.until(ExpectedConditions.attributeToBe(element, "enabled", "true"));
        } catch (TimeoutException e) {
            errLog(timeStamp(SHORT_TIME)
                    + " - "
                    + tag
                    + ": Failed to wait for element to be enabled '"
                    + description
                    + "'");
        }
    }
}
